package com.example.myfirstapp.network;

import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdManager.RegistrationListener;
import android.net.nsd.NsdServiceInfo;


public class a {
	
	RegistrationListener mRegistrationListener;
	
	String mServiceName;
	
	
	//ע��NSD����
	/**
	 * ��δ��뽫���ṩ�ķ�������Ϊ��NsdChat���������ƽ������о��������е��豸�ɼ��� ��Ҫע����ǣ��������ڸ����Ʊ����Ƕ�һ�޶��ġ�
	 * Androidϵͳ���Զ������ͻ�ķ������ơ����ͬʱ��������Ϊ��NsdChat����Ӧ�ã� ����һ���ᱻ�Զ�ת��Ϊ��NsdChat(1)����

�ڶ������������˷������ͣ�����ʹ�õ�ͨ��Э��ʹ����Э�飬 �﷨�ǡ�_< protocol >._< transportlayer >���� ������Ĵ����У�
����ʹ����TCPЭ���ϵ�HTTPЭ�顣 ���Ӧ����Ҫ�ṩ��ӡ�������磬һ̨�����ӡ����Ӧ�ý��������������Ϊ ��_ipp._tcp����
	 * */
	public void registerService(int port) {
	    // Create the NsdServiceInfo object, and populate it.
	    NsdServiceInfo serviceInfo  = new NsdServiceInfo();

	    // The name is subject to change based on conflicts
	    // with other services advertised on the same network.
	    serviceInfo.setServiceName("NsdChat");
	    serviceInfo.setServiceType("_http._tcp.");
	    serviceInfo.setPort(port);
	    
	    
	   // mNsdManager = Context.getSystemService(Context.NSD_SERVICE);

	   // mNsdManager.registerService(
	          //  serviceInfo, NsdManager.PROTOCOL_DNS_SD, mRegistrationListener);
	    
	}
	
	public void initializeRegistrationListener() {
	    mRegistrationListener = new NsdManager.RegistrationListener() {

	        //@Override
	        public void onServiceRegistered(NsdServiceInfo NsdServiceInfo) {
	            // Save the service name.  Android may have changed it in order to
	            // resolve a conflict, so update the name you initially requested
	            // with the name Android actually used.
	            mServiceName = NsdServiceInfo.getServiceName();
	        }

	        //@Override
	        public void onRegistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
	            // Registration failed!  Put debugging code here to determine why.
	        }

	        //@Override
	        public void onServiceUnregistered(NsdServiceInfo arg0) {
	            // Service has been unregistered.  This only happens when you call
	            // NsdManager.unregisterService() and pass in this listener.
	        }

	        //@Override
	        public void onUnregistrationFailed(NsdServiceInfo serviceInfo, int errorCode) {
	            // Unregistration failed.  Put debugging code here to determine why.
	        }
	    };
	}
	
	

}
