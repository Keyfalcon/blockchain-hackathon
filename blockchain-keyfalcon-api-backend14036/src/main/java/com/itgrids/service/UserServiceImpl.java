package com.itgrids.service;

import java.util.List;
import java.util.Random;

import org.appfuse.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.CreateTopicRequest;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.services.sns.model.DeleteTopicRequest;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.SubscribeRequest;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.services.sns.model.UnsubscribeRequest;
import com.itgrids.dao.UserDao;
import com.itgrids.model.User;
import com.itgrids.rest.OtpRequest;
import com.itgrids.rest.UserResponse;
import com.jayway.jsonpath.Criteria;

@Service
@Transactional
public class UserServiceImpl extends GenericManagerImpl<User, Integer> implements UserService {

	private UserDao userDao;

	static String receivedPhone = "";

	// static String ACCESS_KEY = "AKIAICOGZIODEOS6A4OQ";
	// static String SECRET_KEY = "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";
	static String ACCESS_KEY = "AKIAJKLYQ75L5MKY7H4Q";
	static String SECRET_KEY = "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";

	@Autowired
	public UserServiceImpl(UserDao userDao) {
		super(userDao);
		this.userDao = userDao;
	}

	@Override
	public User save(User object) {
		// TODO Auto-generated method stub
		return super.save(object);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return super.getAll();
	}

	@Override
	public User get(Integer id) {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public void remove(Integer id) {
		// TODO Auto-generated method stub
		super.remove(id);
	}

	@Override
	public User getByUserName(String name) {
		return userDao.getByUserName(name);
	}

	@Override
	public User getByNamePassword(String name, String password) {
		return userDao.getByNamePassword(name, password);
	}

	@Override
	public User getByPassword(String password) {
		return userDao.getByPassword(password);
	}

	public UserResponse getOtp(OtpRequest request) {

		receivedPhone = request.getContact();

		Random rnd = new Random();
		Integer n = 100000 + rnd.nextInt(900000);

		AmazonSNSClient snsClient = new AmazonSNSClient(new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY));
		snsClient.setEndpoint("https://sns.us-west-2.amazonaws.com");
		System.out.println(snsClient.listSubscriptions());
		String phoneNumber = "+91" + receivedPhone;
		String topicArn = createSNSTopic(snsClient);
		SubscribeResult subscribeResult = subscribeToTopic(snsClient, topicArn, "sms", phoneNumber);
		String msg = ("Your OTP" + " " + n);
		PublishRequest publishRequest = new PublishRequest(topicArn, msg);
		PublishResult publishResult = snsClient.publish(publishRequest);
		// print MessageId of message published to SNS topic
		System.out.println("MessageId - " + publishResult.getMessageId());

		UnsubscribeRequest unsubscribeRequest = new UnsubscribeRequest();
		AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		// unsubscribeRequest.setRequestCredentials(credentials);
		unsubscribeRequest.setSubscriptionArn(subscribeResult.getSubscriptionArn());
		snsClient.unsubscribe(unsubscribeRequest);

		DeleteTopicRequest deleteTopicRequest = new DeleteTopicRequest(topicArn);
		snsClient.deleteTopic(deleteTopicRequest);
		UserResponse userResponse = new UserResponse();
		userResponse.setOtp(n + "");
		return userResponse;

	}

	public static SubscribeResult subscribeToTopic(AmazonSNSClient snsClient, String topicArn, String protocol,
			String endpoint) {
		SubscribeRequest subscribe = new SubscribeRequest(topicArn, protocol, endpoint);
		SubscribeResult subscribeResult = snsClient.subscribe(subscribe);
		System.out.println("Subscribe request: " + snsClient.getCachedResponseMetadata(subscribe));
		System.out.println("Subscribe result: " + subscribeResult);

		return subscribeResult;
	}

	public static String createSNSTopic(AmazonSNSClient snsClient) {
		CreateTopicRequest createTopic = new CreateTopicRequest("mySNSTopic");
		CreateTopicResult result = snsClient.createTopic(createTopic);
		System.out.println("Create topic request: " + snsClient.getCachedResponseMetadata(createTopic));
		System.out.println("Create topic result: " + result);
		return result.getTopicArn();
	}

	@Override
	public User getByBlockTokenKey(Integer id) {
		return userDao.getByBlockTokenKey(id);
	}

	@Override
	public User getByMobile(String contact) {
		return userDao.getByMobile(contact);
	}
}
