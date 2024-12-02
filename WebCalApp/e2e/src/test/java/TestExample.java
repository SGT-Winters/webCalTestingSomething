import com.microsoft.playwright.Locator;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.*;

import org.junit.jupiter.api.*;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.*;

@UsePlaywright
public class TestExample {

    @Test
    void calculatorWebUi_PageTitle_IsCalculator(Page page) {
        //preq-E2E-TEST-5

        page.navigate("http://localhost:8080/");
        assertThat(page).hasTitle("Calculator");
    }//end of calculatorWebUi_PageTitle_IsCalculator

    @Test
    void sampleStandardDeviation_AddMultipleDoubleValues_ReturnsSampleDeviation(Page page) {
        //preq-E2E-TEST-6

        page.navigate("http://localhost:8080/");
        page.locator("#values").click();
        page.locator("#values").fill("9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();

        Locator responseBox = page.locator(".ResponseBox");
        responseBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String result = responseBox.textContent();

        Assertions.assertEquals("Sample Standard Deviation: 3.0607876523260447", result);
    }//end of sampleStandardDeviation_AddMultipleDoubleValues_ReturnsSampleDeviation

    @Test
    void samplePopulationDeviation_AddValuesOfEmptyTextbox_ReturnsErrorMessage(Page page) {
        //preq-E2E-TEST-7

        page.navigate("http://localhost:8080/");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Population Standard")).click();

        Locator responseBox = page.locator(".ResponseBox");
        responseBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String result = responseBox.textContent();

        Assertions.assertEquals("List must contain at least 2 numbers", result);
    }// end of samplePopulationDeviation_AddValuesOfEmptyTextbox_ReturnsErrorMessage

    @Test
    void sampleStandardDeviation_AddWhenOnly1ValueIsInTheTextbox_ReturnsErrorMessage(Page page) {
        //preq-E2E-TEST-8
        page.navigate("http://localhost:8080/");
        page.locator("#values").click();
        page.locator("#values").fill("1");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Sample Standard")).click();

        Locator responseBox = page.locator(".ResponseBox");
        responseBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String result = responseBox.textContent();

        Assertions.assertEquals("List must contain at least 2 numbers", result);
    }//end of sampleStandardDeviation_AddWhenOnly1ValueIsInTheTextbox_ReturnsErrorMessage

    @Test
    void computeMean_AddMultipleDoubleValues_ReturnsMean(Page page) {
        //preq-E2E-TEST-9

        page.navigate("http://localhost:8080/");
        page.locator("#values").click();
        page.locator("#values").fill("9\n2\n5\n4\n12\n7\n8\n11\n9\n3\n7\n4\n12\n5\n4\n10\n9\n6\n9\n4");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Mean | one value per")).click();

        Locator responseBox = page.locator(".ResponseBox");
        responseBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String result = responseBox.textContent();

        Assertions.assertEquals("Mean: 7.0", result);
    }//end of computeMean_AddMultipleDoubleValues_ReturnsMean

    @Test
    void computeZScore_AddMultipleDoubleValuesOnOneLine_ReturnsZScore(Page page) {
        //preq-E2E-TEST-10

        page.navigate("http://localhost:8080/");
        page.locator("#values").click();
        page.locator("#values").fill("5.5,7,3.060787652326");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Z Score | Value, mean")).click();

        Locator responseBox = page.locator(".ResponseBox");
        responseBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String result = responseBox.textContent();

        Assertions.assertEquals("ZScore: -0.49006993309715474", result);
    }//end of computeZScore_AddMultipleDoubleValuesOnOneLine_ReturnsZScore

    @Test
    void calculateLinearEquation_AddRowsOfXYPairs_ReturnASingleLinearFormula(Page page) {
        //preq-E2E-TEST-11

        page.navigate("http://localhost:8080/");
        page.locator("#values").click();
        page.locator("#values").fill("5,3\n3,2\n2,15\n1,12.3\n7.5,-3\n4,5\n3,17\n4,3\n6.42,4\n34,5\n12,17\n3,-1");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Compute Single Linear")).click();

        Locator responseBox = page.locator(".ResponseBox");
        responseBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String result = responseBox.textContent();

        Assertions.assertEquals("Linear Equation: Single Linear Regression Formula: y = -0.05x + 6.93", result);
    }//end of calculateLinearEquation_AddRowsOfXYPairs_ReturnASingleLinearFormula

    @Test
    void predictY_AddValuesAllOnOneLine_ReturnsAPredictionOfY(Page page) {
        //preq-E2E-TEST-12

        page.navigate("http://localhost:8080/");
        page.locator("#values").click();
        page.locator("#values").fill("6,-0.04596,6.9336");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Predict Y from Linear")).click();

        Locator responseBox = page.locator(".ResponseBox");
        responseBox.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));

        String result = responseBox.textContent();

        Assertions.assertEquals("Single Linear Regression Prediction: 6.65784", result);
    }//end of predictY_AddValuesAllOnOneLine_ReturnsAPredictionOfY

}//end of class TestExample