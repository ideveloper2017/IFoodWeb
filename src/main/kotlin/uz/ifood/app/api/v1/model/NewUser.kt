package uz.ifood.app.api.v1.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

class NewUser:Serializable {

    @JsonProperty("username")
    var username: String? = null

    @JsonProperty("password")
    var password: String? = null

    @JsonProperty("firstName")
    var firstName: String? = null

    @JsonProperty("lastName")
    var lastName: String? = null

    @JsonProperty("email")
    var email: String? = null

    constructor(){}
    constructor(username:String, password:String, firstName:String, lastName:String, email:String) {
        this.username = username
        this.password = password
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }

    companion object {
        private const val serialVersionUID = -1764970284520387975L
    }
}
