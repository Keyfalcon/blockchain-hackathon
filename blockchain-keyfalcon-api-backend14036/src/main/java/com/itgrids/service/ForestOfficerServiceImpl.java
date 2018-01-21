package com.itgrids.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itgrids.dao.RoleDao;
import com.itgrids.dao.UserDao;
import com.itgrids.model.ForestOfficer;
import com.itgrids.model.SampleDetails;
import com.itgrids.model.User;
import com.itgrids.utils.ImageUtility;

@Service
@Transactional
public class ForestOfficerServiceImpl implements ForestOfficerService {

	private UserDao userDao;

	private RoleDao roleDao;

	@Value("${filePath}")
	private String filePath;

	@Override
	public String save(ForestOfficer forestOfficer) {
		List<SampleDetails> sampleDetails = new ArrayList<>();
		for (SampleDetails sampleDetail : forestOfficer.getSampleDetails()) {

			List<String> imageList = new ArrayList<>();
			for (String image : sampleDetail.getImages()) {
				imageList.add(ImageUtility.saveImage(filePath, "Verified_Images", image));
			}

			sampleDetail.setImages(imageList);
		}
		forestOfficer.setSampleDetails(sampleDetails);

		User user = new User();
		user.setName(forestOfficer.getName());
		user.setRoles(roleDao.get(3));
		user.setMobile(forestOfficer.getMobile());
		// user.setBlockTokenKey();
		userDao.save(user);
		return null;
	}

}
