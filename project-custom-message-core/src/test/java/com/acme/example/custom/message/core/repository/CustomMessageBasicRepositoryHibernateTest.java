package com.acme.example.custom.message.core.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.acme.example.custom.message.core.config.CustomMessageConfig;
import com.acme.example.custom.message.core.constant.CustomMessageConstant;
import com.acme.example.custom.message.core.entity.CustomMessage;
import com.acme.example.custom.message.core.factory.dummy.DummyCustomMessageDataFactory;
import com.acme.example.custom.message.core.repository.CustomMessageBasicRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CustomMessageConfig.class})
@ActiveProfiles(profiles={SpringConfigConstant.SPRING_PROFILE_DEVELOPMENT})
@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
public class CustomMessageBasicRepositoryHibernateTest {

	@Resource
	@Qualifier ("customMessageBasicRepository")
	private CustomMessageBasicRepository customMessageBasicRepository;

	private CustomMessage customMessageTest;

	@Before
	public void init() {
		customMessageTest = DummyCustomMessageDataFactory.createSampleDefault();
	}

	@Test
	public void shouldFindAll() {
		final List<CustomMessage> result = customMessageBasicRepository.findAll();
		
		assertNotNull(result);
		assertEquals(CustomMessageConstant.TEST_NUM_MESSAGES, result.size());
	}
	
	@Test
	public void shouldFindByPK() {
		final CustomMessage result = customMessageBasicRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		assertNotNull(result);
		assertEquals(CustomMessageConstant.TEST_USER_MESSAGE_1_ID, result.getId());
	}
	
	@Test
	public void shouldDelete() {
		final CustomMessage origin = customMessageBasicRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);

		assertNotNull(origin);
		
		customMessageBasicRepository.delete(origin);
		
		final CustomMessage deleted = customMessageBasicRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
		assertNull(deleted);
	}
	
	@Test
	public void shouldInsert() {
		final Long newID = Long.valueOf((CustomMessageConstant.TEST_NUM_MESSAGES+1));
		
		customMessageTest.setId(null);
		customMessageTest.setDescription("TEST");
		
		customMessageBasicRepository.saveOrUpdate(customMessageTest);
		
		final CustomMessage result = customMessageBasicRepository.findByPK(newID);
		assertNotNull(result);
		assertEquals("TEST", result.getDescription());	
		
		customMessageBasicRepository.delete(result);
	}
	
	@Test
	public void shouldUpdate() {
		final CustomMessage origin = customMessageBasicRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
		origin.setDescription(null);
		
		customMessageBasicRepository.saveOrUpdate(origin);
		
		final CustomMessage result = customMessageBasicRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
		assertNotNull(result);
		assertNull(result.getDescription());
	}

}