package panel.sdk.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserRequest {

    @NotBlank
    @Size(max = 140)
    private String id;

    @NotBlank
    @Size(max = 140)
    private String name;


}
