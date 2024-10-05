package uz.ifood.app.api.v1.model

import com.fasterxml.jackson.annotation.JsonProperty

class NewRole {
    @JsonProperty("name")
    var name: String? = null
}