package com.neemre.btcdcli4j.daemon.event;

import java.util.Observable;
import java.util.Observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

/**An abstract adapter class for receiving {@code ALERT} notifications. Extend this class to 
 * override any methods of interest.*/
public abstract class AlertListener {

	private static final Logger LOG = LoggerFactory.getLogger(AlertListener.class);

	@Getter
	private Observer observer;


	public AlertListener() {
		observer = new Observer() {
			@Override
			public void update(Observable monitor, Object cause) {
				String alert = (String)cause;
				LOG.trace("-- update(..): forwarding incoming 'ALERT' notification to "
						+ "'alertReceived(..)'");
				alertReceived(alert);
			}
		};
	}

	public void alertReceived(String alert) {}
}