package com.agregio.cucumber;

import com.agregio.entity.Parc;
import com.agregio.repository.ParcRepository;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ParcSteps extends SpringIntegrationTest {
    @Autowired
    ParcRepository parcRepository;

    @When("^The client call to create a parc$")
    public void createAParc() throws IOException {
        executePost("http://localhost:8080/parc/TEST_NAME/EOLIEN/12");
    }

    @Then("^The parc has been created$")
    public void parcHasBeenCreated() {
        List<Parc> parcList = parcRepository.findAll();
        assertThat(parcList.size(), is(1));
    }
}
