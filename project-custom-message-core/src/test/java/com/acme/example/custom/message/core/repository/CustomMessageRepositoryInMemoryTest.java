package com.acme.example.custom.message.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.acme.architecture.common.constant.SpringConfigConstant;
import com.acme.example.custom.message.config.CommonTemplateConfig;
import com.acme.example.custom.message.constant.CustomMessageConstant;
import com.acme.example.custom.message.entity.CustomMessage;
import com.acme.example.custom.message.factory.dummy.DummyCustomMessageDataFactory;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={CommonTemplateConfig.class})
@ActiveProfiles(profiles={SpringConfigConstant.SPRING_PROFILE_DEVELOPMENT})
public class CustomMessageRepositoryInMemoryTest {

	private int NUM_ELEMENTS = 3;
	
	@Resource
	@Qualifier ("customMessageRepositoryInMemory")
	private CustomMessageRepository customMessageRepository;

	private CustomMessage customMessageTest;

	@Before
	public void init() {
		customMessageTest = DummyCustomMessageDataFactory.createSampleDefault();
	}

	@Test
	@Transactional
	public void shouldFindAll() {
		final List<CustomMessage> result = customMessageRepository.findAll();
		
		assertNotNull(result);
		assertEquals(CustomMessageConstant.TEST_NUM_MESSAGES, result.size());
	}
	
	@Test
	@Transactional
	public void shouldFindByPK() {
		final CustomMessage result = customMessageRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
		
		assertNotNull(result);
		assertEquals(CustomMessageConstant.TEST_USER_MESSAGE_1_ID, result.getId());
	}
	
	@Test
	@Transactional
	public void shouldDelete() {
		final CustomMessage origin = customMessageRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);

		assertNotNull(origin);
		
		customMessageRepository.remove(origin);
		
		final CustomMessage deleted = customMessageRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
		assertNull(deleted);
	}
	
	@Test
	@Transactional
	public void shouldInsert() {
		final Long newID = Long.valueOf((CustomMessageConstant.TEST_NUM_MESSAGES+1));
		
		//userMessageTest.setId(newID);
		customMessageTest.setDescription("TEST");
		
		customMessageRepository.insert(customMessageTest);
		
		final CustomMessage result = customMessageRepository.findByPK(newID);
		assertNotNull(result);
		assertEquals("TEST", result.getDescription());	
		
		customMessageRepository.remove(result);
	}
	
	@Test
	@Transactional
	public void shouldUpdate() {
		final CustomMessage origin = customMessageRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
		origin.setDescription(null);
		
		customMessageRepository.update(origin);
		
		final CustomMessage result = customMessageRepository.findByPK(CustomMessageConstant.TEST_USER_MESSAGE_1_ID);
		assertNotNull(result);
		assertNull(result.getDescription());
	}	
	
}