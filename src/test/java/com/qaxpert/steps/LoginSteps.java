package com.qaxpert.steps;

import com.qaxpert.config.Config;
import com.qaxpert.models.login.LoginRequest;
import com.qaxpert.utils.DataFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
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
        loginRequest = DataFactory.validEmailAndPassword();
    }

    @When("envío email y password valido")
    public void enviarLoginConEmailYPasswordValidos() {
        loginRequest = DataFactory.validEmailAndPassword();
        ejecutarLogin();
    }

    @Then("la respuesta debe tener un status {int}")
    public void validarStatusCodeDeLaRespuesta(int statusCode) {
        response.then()
                .statusCode(statusCode)
                .contentType(ContentType.JSON);
    }

    @And("la respuesta debe contener access_token")
    public void validarQueLaRespuestaContieneAccessToken() {
        response.then().body("access_token", notNullValue());
    }

    @And("la respuesta debe contener refresh_token")
    public void validarQueLaRespuestaContieneRefreshToken() {
        response.then().body("refresh_token", notNullValue());
    }

    @And("la respuesta debe contener los datos completos del usuario")
    public void validarDatosCompletosDelUsuario() {
        response.then()
                .body("user", notNullValue())
                .body("user.id", notNullValue())
                .body("user.email", notNullValue());
    }

    // Scenario 2: Login con usuario no registrado

    @Given("que el usuario no está registrado")
    public void prepararUsuarioNoRegistrado() {
        loginRequest = DataFactory.unregisteredUser();
    }

    @When("envío email y password con formato valido")
    public void enviarLoginConUsuarioNoRegistrado() {
        loginRequest = DataFactory.unregisteredUser();
        ejecutarLogin();

    }
    @And("la respuesta debe mostrar un msg {string}")
    public void validarMensajeDeErrorEsperado(String mensajeEsperado) {
        response.then()
                .body("msg", equalTo(mensajeEsperado));
    }

    // Scenario 3: Validación de login exitoso OK

    @And("la respuesta debe contener token_type {string}")
    public void validarTokenType(String tokenType) {
        response.then()
                .body("token_type", equalTo(tokenType));
    }

    // Scenario 4: Login con formato inválido

    @When("envío email y password con formato inválido")
    public void enviarLoginConFormatoDeCredencialesInvalido() {
        loginRequest = DataFactory.invalidEmailAndPasswordFormat();
        ejecutarLogin();
    }

    // Scenario 5: Login solo con email

    @When("envío únicamente el email válido")
    public void enviarLoginConEmailValidoYPasswordVacio() {
        loginRequest = DataFactory.emptyPassword();
        ejecutarLogin();
    }
    // Scenario 6: Login solo con password

    @When("envío únicamente el password válido")
    public void enviarLoginConEmailVacioYPasswordValido() {
        loginRequest = DataFactory.emptyEmail();
        ejecutarLogin();
    }

    // Scenario 7: Login solo con email sin role

    @When("envío solo el email")
    public void enviarLoginSoloConEmail() {
        loginRequest = DataFactory.emptyPassword();
        ejecutarLogin();
    }

    // Scenario 8: Login solo con password sin role

    @When("envío solo el password")
    public void enviarLoginSoloConPassword() {
        loginRequest = DataFactory.emptyEmail();
        ejecutarLogin();
    }

    // Scenario 9: Validación completa de tokens y datos

    @And("la respuesta debe contener los campos de los datos completos del usuario")
    public void validarCamposDeDatosCompletosDelUsuario() {
        response.then()
                .body("user", notNullValue())
                .body("user.id", notNullValue())
                .body("user.email", notNullValue());
    }

    private void ejecutarLogin() {
        response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("apikey","sb_publishable_f98rPx2O8YbjxhH5Sm3u8g_MIFqACVH")
                .queryParam("grant_type", "password")
                .body(loginRequest)
                .when()
                .post("/auth/v1/token");
        response.then().log().all();
    }
}