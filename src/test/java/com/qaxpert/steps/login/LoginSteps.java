package com.qaxpert.steps.login;

import com.qaxpert.config.Config;
import com.qaxpert.config.Endpoints;
import com.qaxpert.models.LoginRequest;
import com.qaxpert.utils.LoginDataFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class LoginSteps {

    private LoginRequest loginRequest;
    private Response response;

    @Before
    public void setup (){
        RestAssured.baseURI = Config.BASE_URL;
    }

    // Scenario 1: Login exitoso con credenciales válidas
    @Given("que existe un aprendiz con credenciales validas")
    public void prepararAprendizConCredencialesValidas() {
        loginRequest = LoginDataFactory.validEmailAndPassword();
    }
    // Scenario 2: Login con usuario no registrado
    @Given("que el usuario no está registrado")
    public void prepararUsuarioNoRegistrado() {
        loginRequest = LoginDataFactory.unregisteredUser();
    }
    //Scenario Outline:
    @Given("que intento iniciar sesion con email {string} y password {string}")
    public void prepararLoginConEmailYPassword(String email, String password){
        loginRequest = new LoginRequest();
        loginRequest.setEmail(email);
        loginRequest.setPassword(password);
    }
    @When("envio la solicitud de login")
    public void envioLaSolicitudDeLogin(){
        ejecutarLogin();
    }

    @Then("la respuesta debe tener un status {int}")
    public void validarStatusCodeDeLaRespuesta(int statusCode) {
        response.then()
                .statusCode(statusCode)
                .contentType(ContentType.JSON);
    }
    @And("la respuesta debe mostrar un msg {string}")
    public void validarMensajeDeErrorEsperado(String mensajeEsperado) {
        response.then()
                .body("msg", equalTo(mensajeEsperado));
    }

    @And("la respuesta debe contener access_token")
    public void validarQueLaRespuestaContieneAccessToken() {
        response.then().body("access_token", notNullValue());
    }

    @And("la respuesta debe contener refresh_token")
    public void validarQueLaRespuestaContieneRefreshToken() {
        response.then().body("refresh_token", notNullValue());
    }
    // Scenario 3: Validación de login exitoso OK
    @And("la respuesta debe contener token_type {string}")
    public void validarTokenType(String tokenType) {
        response.then()
                .body("token_type", equalTo(tokenType));
    }

    // Scenario 9: Validación completa de tokens y datos
    @And("la respuesta debe contener los datos completos del usuario")
    public void validarDatosCompletosDelUsuario() {
        response.then()
                .body("user", notNullValue())
                .body("user.id", notNullValue())
                .body("user.email", notNullValue());
    }

    private void ejecutarLogin() {
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("apikey",Config.API_KEY)
                .queryParam("grant_type", "password")
                .body(loginRequest)
                .when()
                .post(Endpoints.LOGIN);
    }
}