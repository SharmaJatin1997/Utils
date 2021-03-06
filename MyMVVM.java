package com.saahayak.saahayak.Utils;

import android.app.Activity;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.saahayak.saahayak.ApiClient.ClientApi;
import com.saahayak.saahayak.Interface.SAAHAYAKInterface;
import com.saahayak.saahayak.response.AllBookingDetailPojo;
import com.saahayak.saahayak.response.AllServicePojo;
import com.saahayak.saahayak.response.BannerVedioPojo;
import com.saahayak.saahayak.response.BookingPojo;
import com.saahayak.saahayak.response.CarWashingCategoriesPojo;
import com.saahayak.saahayak.response.CarWashingSegmentPojo;
import com.saahayak.saahayak.response.CarWashingServicePackPojo;
import com.saahayak.saahayak.response.GetCartDetailPojo;
import com.saahayak.saahayak.response.HotDealPojo;
import com.saahayak.saahayak.response.PaymentPojo;
import com.saahayak.saahayak.response.PopularServicePojo;
import com.saahayak.saahayak.response.RegisterPojo;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyMVVM extends ViewModel {

    SAAHAYAKInterface saahayakInterface = ClientApi.apiClient().create(SAAHAYAKInterface.class);

    private MutableLiveData<RegisterPojo> userRegister;

    public LiveData<RegisterPojo> userRegisteration(final Activity activity, String phone, String reg_id, String device_type, String country_code) {
        userRegister = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.register(phone, reg_id, device_type, country_code).enqueue(new Callback<RegisterPojo>() {
                @Override
                public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        userRegister.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<RegisterPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return userRegister;
    }


    private MutableLiveData<RegisterPojo> matchOtp;

    public LiveData<RegisterPojo> userOtpMatch(final Activity activity, String otp, String phone, String country_code) {
        matchOtp = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.matchotp(otp, phone, country_code).enqueue(new Callback<RegisterPojo>() {
                @Override
                public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        matchOtp.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<RegisterPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return matchOtp;
    }

    private MutableLiveData<RegisterPojo> resendOtp;

    public LiveData<RegisterPojo> userResendOtp(final Activity activity, String phone, String country_code) {
        resendOtp = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.resendOtp(phone, country_code).enqueue(new Callback<RegisterPojo>() {
                @Override
                public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        resendOtp.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<RegisterPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return resendOtp;
    }

    private MutableLiveData<RegisterPojo> userInfo;

    public LiveData<RegisterPojo> userInfoRegister(final Activity activity, String name, String email, String address, String id) {
        userInfo = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.userInfo(name, email, address, id).enqueue(new Callback<RegisterPojo>() {
                @Override
                public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        userInfo.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<RegisterPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return userInfo;
    }

    private MutableLiveData<RegisterPojo> setPassword;

    public LiveData<RegisterPojo> userSetPassword(final Activity activity, String id, String password) {
        setPassword = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.userInfoPassword(id, password).enqueue(new Callback<RegisterPojo>() {
                @Override
                public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        setPassword.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<RegisterPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return setPassword;
    }

    private MutableLiveData<RegisterPojo> login;

    public LiveData<RegisterPojo> userLogin(final Activity activity, String phone, String reg_id, String device_type, String country_code, String password) {
        login = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.userLogin(phone, reg_id, device_type, country_code, password).enqueue(new Callback<RegisterPojo>() {
                @Override
                public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        login.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<RegisterPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return login;
    }

    private MutableLiveData<RegisterPojo> updateUserInfo;

    public LiveData<RegisterPojo> updateUserInfoRegister(final Activity activity, RequestBody name, RequestBody email, RequestBody address, RequestBody id, MultipartBody.Part image) {
        updateUserInfo = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.updateUserInfo(name, email, address, id, image).enqueue(new Callback<RegisterPojo>() {
                @Override
                public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        updateUserInfo.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<RegisterPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return updateUserInfo;
    }

    private MutableLiveData<AllServicePojo> JugaarList;

    public LiveData<AllServicePojo> JugaarListAll(final Activity activity) {
        JugaarList = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {

            saahayakInterface.JugaarList().enqueue(new Callback<AllServicePojo>() {
                @Override
                public void onResponse(Call<AllServicePojo> call, Response<AllServicePojo> response) {

                    if (response.body() != null) {
                        JugaarList.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<AllServicePojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return JugaarList;
    }

    private MutableLiveData<PopularServicePojo> PopularList;

    public LiveData<PopularServicePojo> PopularAllList(final Activity activity) {
        PopularList = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
//                CommonUtils.showProgress(activity, "Loading....Please wait");
            saahayakInterface.PopularList().enqueue(new Callback<PopularServicePojo>() {
                @Override
                public void onResponse(Call<PopularServicePojo> call, Response<PopularServicePojo> response) {
//                        CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        PopularList.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<PopularServicePojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return PopularList;
    }

    private MutableLiveData<BannerVedioPojo> VedioList;

    public LiveData<BannerVedioPojo> AllVedioList(final Activity activity) {
        VedioList = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.VedioList().enqueue(new Callback<BannerVedioPojo>() {
                @Override
                public void onResponse(Call<BannerVedioPojo> call, Response<BannerVedioPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        VedioList.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<BannerVedioPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return VedioList;
    }

    private MutableLiveData<HotDealPojo> HotDealList;

    public LiveData<HotDealPojo> AllHotDeal(final Activity activity) {
        HotDealList = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
//            CommonUtils.showProgress(activity, "Loading....Please wait");
            saahayakInterface.HotDealList().enqueue(new Callback<HotDealPojo>() {
                @Override
                public void onResponse(Call<HotDealPojo> call, Response<HotDealPojo> response) {
//                    CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        HotDealList.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<HotDealPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return HotDealList;
    }

    private MutableLiveData<CarWashingCategoriesPojo> CarWashingCategory;

    public LiveData<CarWashingCategoriesPojo> AllCarWashingCategory(final Activity activity, String service_id) {
        CarWashingCategory = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.CarWashingCategory(service_id).enqueue(new Callback<CarWashingCategoriesPojo>() {
                @Override
                public void onResponse(Call<CarWashingCategoriesPojo> call, Response<CarWashingCategoriesPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        CarWashingCategory.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<CarWashingCategoriesPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return CarWashingCategory;
    }

    private MutableLiveData<CarWashingSegmentPojo> CarWashingSegment;

    public LiveData<CarWashingSegmentPojo> AllCarWashingSegment(final Activity activity, String cat_id) {
        CarWashingSegment = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
//            CommonUtils.showProgress(activity, "Loading....Please wait");
            saahayakInterface.CarWashingSegment(cat_id).enqueue(new Callback<CarWashingSegmentPojo>() {
                @Override
                public void onResponse(Call<CarWashingSegmentPojo> call, Response<CarWashingSegmentPojo> response) {
//                    CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        CarWashingSegment.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<CarWashingSegmentPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return CarWashingSegment;
    }

    private MutableLiveData<CarWashingServicePackPojo> CarWashingServicePack;

    public LiveData<CarWashingServicePackPojo> AllCarWashingServicePack(final Activity activity, String subcat_id) {
        CarWashingServicePack = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
//            CommonUtils.showProgress(activity, "Loading....Please wait");
            saahayakInterface.CarWashingServicePack(subcat_id).enqueue(new Callback<CarWashingServicePackPojo>() {
                @Override
                public void onResponse(Call<CarWashingServicePackPojo> call, Response<CarWashingServicePackPojo> response) {
//                    CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        CarWashingServicePack.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<CarWashingServicePackPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return CarWashingServicePack;
    }

    private MutableLiveData<BookingPojo> Booking;

    public LiveData<BookingPojo> AllBookingService(final Activity activity, String user_id, String service_id, String category_id, String subcat_id, String package_id, String date, String phone, String address, String country_code, String comment, String price) {
        Booking = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.Booking(user_id, service_id, category_id, subcat_id, package_id, date, phone, address, country_code, comment, price).enqueue(new Callback<BookingPojo>() {
                @Override
                public void onResponse(Call<BookingPojo> call, Response<BookingPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        Booking.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<BookingPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return Booking;
    }

    private MutableLiveData<AllBookingDetailPojo> AllBookingDetail;

    public LiveData<AllBookingDetailPojo> AllBookingsDetail(final Activity activity, String user_id, String status) {
        AllBookingDetail = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
//            CommonUtils.showProgress(activity, "Loading....Please wait");
            saahayakInterface.AllBookingDetail(user_id, status).enqueue(new Callback<AllBookingDetailPojo>() {
                @Override
                public void onResponse(Call<AllBookingDetailPojo> call, Response<AllBookingDetailPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        AllBookingDetail.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<AllBookingDetailPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return AllBookingDetail;
    }


    private MutableLiveData<RegisterPojo> UserDetail;

    public LiveData<RegisterPojo> AllUserDetail(final Activity activity, String user_id) {
        UserDetail = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
//            CommonUtils.showProgress(activity, "Loading....Please wait");
            saahayakInterface.UserDetail(user_id).enqueue(new Callback<RegisterPojo>() {
                @Override
                public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        UserDetail.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<RegisterPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return UserDetail;
    }


    private MutableLiveData<Map> addCart;

    public LiveData<Map> AddCart(final Activity activity, String user_id, String service_id, String cat_id, String subcat_id, String package_id, String price) {
        addCart = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.AddCart(user_id, service_id, cat_id, subcat_id, package_id, price).enqueue(new Callback<Map>() {
                @Override
                public void onResponse(Call<Map> call, Response<Map> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        addCart.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<Map> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return addCart;
    }

    private MutableLiveData<GetCartDetailPojo> getCart;

    public LiveData<GetCartDetailPojo> GetCartDetails(final Activity activity, String user_id) {
        getCart = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.GetCartDetail(user_id).enqueue(new Callback<GetCartDetailPojo>() {
                @Override
                public void onResponse(Call<GetCartDetailPojo> call, Response<GetCartDetailPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        getCart.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<GetCartDetailPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return getCart;
    }


    private MutableLiveData<Map> delete_cart;

    public LiveData<Map> DeleteCart(final Activity activity, String cart_id) {
        delete_cart = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.DeleteCart(cart_id).enqueue(new Callback<Map>() {
                @Override
                public void onResponse(Call<Map> call, Response<Map> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        delete_cart.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<Map> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return delete_cart;
    }

    private MutableLiveData<PaymentPojo> orderIdGenerate;

    public LiveData<PaymentPojo> OrderId(final Activity activity, String amount) {
        orderIdGenerate = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.OrderId(amount).enqueue(new Callback<PaymentPojo>() {
                @Override
                public void onResponse(Call<PaymentPojo> call, Response<PaymentPojo> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        orderIdGenerate.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<PaymentPojo> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return orderIdGenerate;
    }



    private MutableLiveData<Map> checkPaymentVerificationStatus;

    public LiveData<Map> PaymentStatus(final Activity activity, String razorpay_order_id,String razorpay_payment_id,String razorpay_signature,String booking_id) {
        checkPaymentVerificationStatus = new MutableLiveData<>();
        if (CommonUtils.isNetworkConnected(activity)) {
            com.omninos.util_data.CommonUtils.showProgress(activity);
            saahayakInterface.PaymentStatus(razorpay_order_id,razorpay_payment_id,razorpay_signature,booking_id).enqueue(new Callback<Map>() {
                @Override
                public void onResponse(Call<Map> call, Response<Map> response) {
                    com.omninos.util_data.CommonUtils.dismissProgress();
                    if (response.body() != null) {
                        checkPaymentVerificationStatus.postValue(response.body());
                    }
                }

                @Override
                public void onFailure(Call<Map> call, Throwable t) {
                    Toast.makeText(activity, t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            Toast.makeText(activity, "No Internet Connection", Toast.LENGTH_SHORT).show();
        }
        return checkPaymentVerificationStatus;
    }

}