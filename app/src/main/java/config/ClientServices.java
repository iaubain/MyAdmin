package config;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import simplebean.dippingbean.DippingBean;
import simplebean.dippingbean.DippingResp;
import simplebean.loginbean.AuthenticationBean;
import simplebean.loginbean.AuthenticationResp;
import simplebean.tankbean.TankList;
import simplebean.tankingbean.TankingBean;
import simplebean.tankingbean.TankingResp;

/**
 * Created by Owner on 7/9/2016.
 */
public interface ClientServices {
    //login client service
    @POST(AppUrl.loginUrl)
    Call<AuthenticationResp> loginUser(@Body AuthenticationBean authenticationBean);

    //Dipping
    @POST(AppUrl.dipping)
    Call<DippingResp> dipping(@Body DippingBean dippingBean);

//    //Tank List
//    @GET(AppUrl.checkBalanceUrl+"/{msisdn}")
//    Call<BalanceRespopnse> getWalletBalance(@Path("msisdn") String msisdn);

    //tanking
    @POST(AppUrl.tanking)
    Call<TankingResp> tanking(@Body TankingBean tankingBean);

    //Tank List
    @GET(AppUrl.tankList)
    Call<TankList> getTankList();
//
//    //getPayment mode list
//    @GET(BaseUrl.paymentModes)
//    Call<PaymentModesResponse> getPaymentModes();
//
//    //initiate wallet recharge
//    @POST(BaseUrl.initiateWalletRecharge)
//    Call<StatusUsage> initWalletRecharge(@Body InitiateWalletRecharge initiateWalletRecharge);
//
//    //confirm wallet recharge
//    @POST(BaseUrl.confirmWalletRecharge)
//    Call<StatusUsage> confWalletRecharge(@Body ConfirmWalletPayment confirmWalletPayment);
}
