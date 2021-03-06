package com.codeborne.selenide;

import com.codeborne.selenide.extension.MockWebDriverExtension;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.WebDriverRunner.webdriverContainer;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockWebDriverExtension.class)
class SelenideTest implements WithAssertions {
  @Test
  void getJavascriptErrors_returnsEmptyListIfWebdriverIsNotStarted() {
    doThrow(new RuntimeException("should not start webdriver if not started yet")).when(webdriverContainer).getWebDriver();
    assertThat(Selenide.getJavascriptErrors())
      .hasSize(0);
  }
}
