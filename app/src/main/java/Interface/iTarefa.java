package Interface;

import Model.TarefaResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Gabriel on 21/11/2017.
 */

public interface iTarefa {

    @GET("./")
    Call<TarefaResponse> getTarefas();

}
