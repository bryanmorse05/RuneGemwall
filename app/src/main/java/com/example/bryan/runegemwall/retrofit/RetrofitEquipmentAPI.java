package com.example.bryan.runegemwall.retrofit;

import com.example.bryan.runegemwall.models.EquipmentModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitEquipmentAPI {
    //The key changed after I invited others to the spreadsheet.  Be careful.  Or, it could be that
    //it changes daily.  Need to verify.

    @GET("echo?user_content_key=KZGdYB4M6-qjW-5tamCAcW9wb4Oxni8i8fZASqmei3ny4utjFZyk3AIjJkRonWzAh" +
            "G4dlUJs-6pgsTItYx94kluV6RJVyvDRm5_BxDlH2jW0nuo2oDemN9CCS2h10ox_1xSncGQajx_ryfhECjZEnA" +
            "iTuK5e8irlJadEbfv9qpRQvWnG0MX4c-4RtXA1hKqKrbnVkFmDbPiVVZQ2ChIn05cdv3aNHr6K&lib=MozLgG" +
            "Lqoz4KJqI7kDH4PiT1fdgA3M0R2")
    Call<List<EquipmentModel>> getEvents();
}
