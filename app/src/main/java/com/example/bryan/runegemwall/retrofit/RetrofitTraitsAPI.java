package com.example.bryan.runegemwall.retrofit;

import com.example.bryan.runegemwall.models.EquipmentModel;
import com.example.bryan.runegemwall.models.TraitsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitTraitsAPI {
    //The key changed after I invited others to the spreadsheet.  Be careful.  Or, it could be that
    //it changes daily.  Need to verify.

    @GET("echo?user_content_key=fKPMSJjg-QIl4zjpo8Y8ONDkMiZeJYF2i9QqknNoec-0apKJKvfReFlfyTAmPIG" +
            "719v4_6WHp8GgsiPtS-wuRsEFXy14WmKsm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECj" +
            "ZEnF-aTXTYINQg_9o21meOFlAHyGMfPqv1SPMMQtmwBUeTwyeHq7S_LTS8QQ5V0l-U8eIqWsDnSrEd&lib=" +
            "Mcxsr1cmRJgqM40PGR5nL1D1fdgA3M0R2")
    Call<List<TraitsModel>> getEvents();
}
