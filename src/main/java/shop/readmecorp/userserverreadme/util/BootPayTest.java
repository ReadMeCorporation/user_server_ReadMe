package shop.readmecorp.userserverreadme.util;

import com.google.gson.Gson;
import kr.co.bootpay.Bootpay;
import kr.co.bootpay.model.request.*;
import kr.co.bootpay.model.response.ResDefault;

import java.util.HashMap;

public class BootPayTest {
    static Bootpay bootpay;
        static Gson gson = new Gson();
    public static void main(String[] args) {
        bootpay = new Bootpay("6441fdbb755e27001be57da4", "JKGhJCCpeObFzjdN0i7+A7ovJCXQU1Of4FIL9ZuDE4w=");

        goGetToken();
//        goVerfity();
//        receiptCancel();
//        getBillingKey();
//        requestSubscribe();
//        reserveSubscribe();
//        reserveCancelSubscribe();
//        destroyBillingKey();
//        getUserToken();
//        requestLink();
//        submit();
//        certificate();
    }

    public static void goGetToken() {
        try {
            HashMap<String, Object> res = bootpay.getAccessToken();
            System.out.println(gson.toJson(res));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static void getBillingKey() {
//        Subscribe subscribe = new Subscribe();
//        subscribe.itemName = "정기결제 테스트 아이템";
//        subscribe.orderId = "" + (System.currentTimeMillis() / 1000);
//        subscribe.pg = "payapp";
//        subscribe.cardNo = "5570**********1074"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
//        subscribe.cardPw = "**"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
//        subscribe.expireYear = "**"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
//        subscribe.expireMonth = "**"; //실제 테스트시에는 *** 마스크처리가 아닌 숫자여야 함
//        subscribe.identifyNumber = ""; //주민등록번호 또는 사업자 등록번호 (- 없이 입력)
//
//        subscribe.userInfo = new User();
//        subscribe.userInfo.username = "홍길동";
//        subscribe.userInfo.phone = "01011112222";
//
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.getBillingKey(subscribe);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void destroyBillingKey() {
//        String receiptId = "6100e7ea0d681b001fd4de69";
//        try {
//            ResDefault res = bootpay.destroyBillingKey(receiptId);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void requestSubscribe() {
//        SubscribePayload payload = new SubscribePayload();
//        payload.billingKey = "618c661d019943003944d5ec";
//        payload.itemName = "아이템01";
//        payload.price = 1000;
//        payload.orderId = "" + (System.currentTimeMillis() / 1000);
//
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.requestSubscribe(payload);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void reserveSubscribe() {
//        SubscribePayload payload = new SubscribePayload();
//
//        payload.billingKey = "619af3fd27018000269761d4";
//        payload.itemName = "아이템01";
//        payload.price = 1000;
//        payload.orderId = "" + (System.currentTimeMillis() / 1000);
//        payload.executeAt = (System.currentTimeMillis() / 1000) + 10; // 결제 승인 시점
//
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.reserveSubscribe(payload);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void reserveCancelSubscribe() {
//        String receiptId = "618c66320d681b00445194b5";
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.reserveCancelSubscribe(receiptId);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void receiptCancel() {
//        Cancel cancel = new Cancel();
//        cancel.receiptId = "6100e77a019943003650f4d5";
//        cancel.name = "관리자";
//        cancel.reason = "테스트 결제";
////        cancel.price = 1000.0; //부분취소 요청시
////        cancel.cancelId = "12342134"; //부분취소 요청시, 중복 부분취소 요청하는 실수를 방지하고자 할때 지정
////        RefundData refund = new RefundData(); // 가상계좌 환불 요청시, 단 CMS 특약이 되어있어야만 환불요청이 가능하다.
////        refund.account = "675601012341234"; //환불계좌
////        refund.accountholder = "홍길동"; //환불계좌주
////        refund.bankcode = BankCode.getCode("국민은행");//은행코드
////        cancel.refund = refund;
//
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.receiptCancel(cancel);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void getUserToken() {
//        UserToken userToken = new UserToken();
//        userToken.userId = "1234"; // 개발사에서 관리하는 회원 고유 번호
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.getUserToken(userToken);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void requestLink() {
//        Payload payload = new Payload();
//        payload.orderId = "1234";
//        payload.price = 1000;
//        payload.name = "테스트 결제";
//        payload.pg = "payapp";
////        payload.method = "vbank";
//
//        User user = new User();
//        user.username = "홍길동";
//        user.phone = "01012341234";
//        payload.userInfo = user;
//
//        Extra extra = new Extra();
////        extra.rawData = 1;
//        payload.extra = extra;
//
//
//
//
//        try {
//            ResDefault res = bootpay.requestLink(payload);
//            System.out.println(res.data);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void submit() {
//        String receiptId = "6100e8e7019943003850f9b0";
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.submit(receiptId);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void goVerfity() {
//        String receiptId = "6100e77a019943003650f4d5";
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.verify(receiptId);
//            System.out.println(res.data.get("receipt_id"));
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void certificate() {
//        String receiptId = "6184f5310d681b0020511c23";
//        try {
//            ResDefault<HashMap<String, Object>> res = bootpay.certificate(receiptId);
//            System.out.println(res.toJson());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
