package com.itgrids.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.protocol.Web3j;

import com.amazonaws.util.json.JSONException;
import com.itgrids.dao.ExampleDao;
import com.itgrids.dao.FarmerDao;
import com.itgrids.dao.LocationDetailsDao;
import com.itgrids.dao.LocationImagesDao;
import com.itgrids.dao.NotificationDao;
import com.itgrids.dao.RoleDao;
import com.itgrids.dao.UserDao;
import com.itgrids.model.ExampleModel;
import com.itgrids.model.Farmer;
import com.itgrids.model.LocationDetails;
import com.itgrids.model.LocationImages;
import com.itgrids.model.Notification;
import com.itgrids.model.User;
import com.itgrids.rest.AddStatusRequest;
import com.itgrids.rest.GetFarmersByStatusRequest;
import com.itgrids.utils.ImageUtility;
import com.itgrids.utils.NotificationUtility;
import com.keyfalcon.blockchain.config.HttpService;

import rx.Subscription;

@Service
@Transactional
public class FarmerServiceImpl extends GenericManagerImpl<Farmer, Integer> implements FarmerService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private RoleDao roleDao;

	private FarmerDao farmerDao;

	@Autowired
	private LocationDetailsDao locationDetailsDao;

	@Autowired
	private LocationImagesDao locationImagesDao;

	@Autowired
	private NotificationDao notificationDao;

	@Autowired
	public FarmerServiceImpl(FarmerDao farmerDao) {
		super(farmerDao);
		this.farmerDao = farmerDao;
	}

	@Value("${filePath}")
	private String filePath;

	@Override
	public Farmer saveFarmer(Farmer farmer) {

		Farmer farmer1 = farmerDao.save(farmer);

		for (LocationDetails details : farmer.getLocationDetails()) {
			details.setFarmer(farmer1);
			LocationDetails locationDetails = locationDetailsDao.save(details);
			for (String image : details.getImages()) {
				LocationImages locationImages = new LocationImages();
				locationImages.setImage(ImageUtility.saveImage(filePath, "Location_Images", image));
				locationImages.setLocationDetails(locationDetails);
				locationImagesDao.save(locationImages);

			}

		}

		User user = new User();
		user.setName(farmer.getName());
		user.setRoles(roleDao.get(1));
		user.setFcmToken(farmer.getFcmToken());
		user.setMobile(farmer.getPhoneNumber());
		user.setFarmerId(farmer1.getId());
		userDao.save(user);
		return farmer1;

	}

	@Override
	public List<LocationDetailResponse> getDetailByFarmer(Integer id) {
		// List<String> images = new ArrayList<>();
		// images.add("vbnv");
		// LocationDetails locationDetails1 = new LocationDetails("1212", 52.22, 55.22,
		// 10.00, "vncnv", "Black", images,
		// "request");
		// LocationDetails locationDetails2 = new LocationDetails("1212", 52.22, 55.22,
		// 10.00, "vncnv", "Black", images,
		// "request");
		// List<LocationDetails> locationDetails3 = new ArrayList<>();
		// locationDetails3.add(locationDetails1);
		// locationDetails3.add(locationDetails2);
		// List<Farmer> farmers = new ArrayList<>();
		// Farmer farmer = new Farmer("Shylesh", "123456789", "1111111111", "sbi",
		// "12112", "12312", locationDetails3);
		// return farmer;

		List<LocationDetails> locationDetails = locationDetailsDao.getByFarmer(id);
		List<LocationDetailResponse> list = new ArrayList<>();
		for (LocationDetails details : locationDetails) {
			LocationDetailResponse response = new LocationDetailResponse(details.getSurveyNumber(),
					details.getSoilType(), details.getArea(), details.getLatitude(), details.getLongitude(),
					details.getWaterResource());
			list.add(response);
		}
		// farmer.setLocationDetails(locationDetails);
		return list;

	}

	@Override
	public Farmer getProfileByFarmer(Integer id) {
		// List<String> images = new ArrayList<>();
		// images.add("vbnv");
		// List<LocationDetails> locationDetails3 = new ArrayList<>();
		// List<Farmer> farmers = new ArrayList<>();
		// Farmer farmer = new Farmer("Shylesh", "123456789", "1111111111", "sbi",
		// "12112", "12312", locationDetails3);
		// Farmer farmer2 = new Farmer();
		// org.springframework.beans.BeanUtils.copyProperties(farmer, farmer2,
		// "locationDetails");
		// return farmer2;
		Farmer farmer = farmerDao.get(id);
		Farmer farmer2 = new Farmer();
		org.springframework.beans.BeanUtils.copyProperties(farmer, farmer2, "locationDetails");
		return farmer2;
	}

	@Override
	public List<Farmer> getAllFarmers() {
		// List<String> images = new ArrayList<>();
		// images.add("vbnv");
		// List<LocationDetails> locationDetails3 = new ArrayList<>();
		// List<Farmer> farmers = new ArrayList<>();
		// Farmer farmer = new Farmer("Shylesh", "123456789", "1111111111", "sbi",
		// "12112", "12312", locationDetails3);
		// Farmer farmer2 = new Farmer("KIran", "123456789", "1111111111", "sbi",
		// "12112", "12312", locationDetails3);
		// farmers.add(farmer);
		// farmers.add(farmer2);
		// return farmers;
		List<Farmer> farmers = farmerDao.getAll();
		return farmers;
	}

	@Override
	public void setStatus(AddStatusRequest addStatusRequest) {
		LocationDetails locationDetails = locationDetailsDao.get(addStatusRequest.getId());
		locationDetails.setStatus(addStatusRequest.getStatus());
		locationDetailsDao.save(locationDetails);

		NotificationUtility notificationUtility = new NotificationUtility();
		User user = userDao.getByBlockTokenKey(locationDetails.getFarmer().getId());
		Notification notification = new Notification();
		try {
			if (addStatusRequest.getStatus().equalsIgnoreCase("clarify")) {
				notificationUtility.sendNotification(user.getFcmToken(),
						"Your request for seedlings need clarification ");
				notification.setMessage("Your request for seedlings need clarification ");
			} else {
				notificationUtility.sendNotification(user.getFcmToken(),
						"Your request for seedlings has been " + addStatusRequest.getStatus());
				notification.setMessage("Your request for seedlings has been " + addStatusRequest.getStatus());

			}
			notification.setCreatedDateTime(new Date());
			notification.setFarmer(locationDetails.getFarmer());
			notificationDao.save(notification);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
