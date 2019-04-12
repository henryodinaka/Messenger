package com.leo.henry.messenger.activemq.service;

import com.leo.henry.messenger.activemq.model.ListOfActiveMqQueue;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


public class ActiveMqQueueTransformer {

	private JAXBContext jaxbContext;

	public ListOfActiveMqQueue convertFromInputStream(InputStream inputs) {
		if (inputs != null) {
			try {
				jaxbContext = JAXBContext.newInstance(ListOfActiveMqQueue.class);
				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

				return (ListOfActiveMqQueue) jaxbUnmarshaller.unmarshal(inputs);

			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
