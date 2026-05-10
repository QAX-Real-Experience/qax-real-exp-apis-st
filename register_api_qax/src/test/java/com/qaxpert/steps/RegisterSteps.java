package com.qaxpert.steps;

import com.qaxpert.config.Config;
import com.qaxpert.config.Endpoints;
import com.qaxpert.models.RegisterRequest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.cucumber.java.Before;
import com.qaxpert.utils.DataFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class RegisterSteps {

    private RegisterRequest registerRequest;
    private Response response;

    @Before
    public void setup (){
        RestAssured.baseURI = Config.BASE_URL;
    }
    //Scenario 1
    @Given("que tengo los datos obligatorios de un usuario nuevo")
    public void registrarUsuarioSatisfactoriamente(){
        registerRequest = DataFactory.registerANewUserSuccessfully();
    }
    @When("envio la solicitud de registro")
    public void envioLaSolicitudDeRegistro(){
        ejecutarRegistro();
    }
    @Then("la respuesta debe tener un status {int}")
    public void validarStatusCodeDeLaRespuesta(int statusCode){
        response.then()
                .statusCode(statusCode)
                .contentType(ContentType.JSON);
    }
    @And("la respuesta debe contener el user_id del usuario registrado")
    public void obtenerUserId(){
        response.then()
                .body("user.id",notNullValue())
                .body("user.identities[0].user_id",notNullValue());

    }
    @And("la respuesta debe contener los datos principales del usuario registrado")
    public void obtenerDatosUsuarioRegistrado(){
        response.then()
                .body("user.id",notNullValue())
                .body("user.aud",equalTo("authenticated"))
                .body("user.role",equalTo("authenticated"))
                .body("user.email",notNullValue())
                .body("user.email_confirmed_at",notNullValue());
    }

    @Given("que intento registrar un usuario con email {string}, password {string}, nombre completo {string}, pais {string} y whatsapp {string}")
    public void registrarUserConDatosIncompletosOInvalidos(
            String email,
            String password,
            String fullname,
            String country,
            String whatsapp){
        registerRequest = DataFactory.customRegisterUser(
                email,
                password,
                fullname,
                country,
                whatsapp);
    }

    @And("la respuesta debe mostrar un mensaje de validacion {string}")
    public void registrarMensajeDeValidacion(String mensajeDeValidacion){
        response.then().body("msg",equalTo(mensajeDeValidacion));
    }
    @Given("que ya existe un usuario registrado con un correo definido")
    public void registerAnExistentUser(){
        registerRequest = DataFactory.registerAUserWithExistingEmail();
    }

    private void ejecutarRegistro(){
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("apikey", Config.API_KEY)
                .body(registerRequest)
                .when()
                .post(Endpoints.REGISTER);
    }

}
