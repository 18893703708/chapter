//package com.huyun.common.service;
//
//
//
//import com.alipay.api.AlipayApiException;
//import com.alipay.api.AlipayClient;
//import com.alipay.api.DefaultAlipayClient;
//import com.alipay.api.domain.AlipayTradeAppPayModel;
//import com.alipay.api.request.AlipayTradeAppPayRequest;
//import com.alipay.api.response.AlipayTradeAppPayResponse;
//
//import com.huyun.payment.bo.AlipayConfig;
//import com.huyun.payment.model.Constants;
//import com.huyun.payment.model.PaymentMethod;
//import com.huyun.payment.model.Product;
//import com.huyun.payment.service.AliPayService;
//import com.huyun.payment.service.PaymentMethodService;
//import com.huyun.utils.JsonUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//
//
//@Service
//public class AliPayServiceImpl implements AliPayService {
//	@Autowired
//	PaymentMethodService paymentMethodService;
//
//	@Override
//	public String appPay(Product product) {
//		//查询支付宝配置
//		PaymentMethod method = paymentMethodService.findByPcode("alipay");
//		AlipayConfig alipayConfig= JsonUtils.jsonToPojo(method.getParams(), AlipayConfig.class);
//		String orderString = Constants.FAIL;
//		//实例化客户端
//		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", alipayConfig.getAppId(), alipayConfig.getPrivateKey() , "json", "UTF-8", alipayConfig.getAlipayPublicKey(), "RSA2");
//		//原实例化客户端代码
////		AlipayClient alipayClient = AliPayConfig.getAlipayClient();
//		// 实例化具体API对应的request类,类名称和接口名称对应,当前调用接口名称：alipay.trade.app.pay
//		AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//		// SDK已经封装掉了公共参数，这里只需要传入业务参数。以下方法为sdk的model入参方式(model和biz_content同时存在的情况下取biz_content)。
//		AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
//		model.setBody(product.getBody());
//		model.setSubject(product.getSubject());
//		model.setOutTradeNo(product.getOutTradeNo());
//		model.setTimeoutExpress("30m");
//		model.setTotalAmount(product.getTotalFee());
//		model.setProductCode("QUICK_MSECURITY_PAY");
//		request.setBizModel(model);
//		request.setNotifyUrl(alipayConfig.getUrl());
//		try {
//			// 这里和普通的接口调用不同，使用的是sdkExecute
//			AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
//			orderString  = response.getBody();//就是orderString 可以直接给客户端请求，无需再做处理。
//			//System.out.println(response.getBody());
//		} catch (AlipayApiException e) {
//			e.printStackTrace();
//		}
//		return orderString ;
//	}
//}
