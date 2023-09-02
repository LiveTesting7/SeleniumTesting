$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Myt.feature");
formatter.feature({
  "name": "To validate Mythra login functionality",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@FeatureOne"
    }
  ]
});
formatter.scenario({
  "name": "To validate positive combination of Mynthra login functionality",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@FeatureOne"
    },
    {
      "name": "@regression"
    },
    {
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "name": "To open browser and maximize window",
  "keyword": "Given "
});
formatter.match({
  "location": "Myt_challenges.toOpenBrowserAndMaximizeWindow()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To launch the url",
  "keyword": "When "
});
formatter.match({
  "location": "Myt_challenges.toLaunchTheUrl()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To enter registered PhoneNumber in PhoneNumber field",
  "rows": [
    {
      "cells": [
        "Number1",
        "987654321"
      ]
    },
    {
      "cells": [
        "Number2",
        "3457895678"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Myt_challenges.toEnterRegisteredPhoneNumberInPhoneNumberField(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To enter password in Password field",
  "rows": [
    {
      "cells": [
        "Password1",
        "Password2",
        "Password3"
      ]
    },
    {
      "cells": [
        "12345",
        "1234567",
        "12345678"
      ]
    },
    {
      "cells": [
        "ABCD",
        "ABCDE",
        "ABCDEF"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "Myt_challenges.toEnterPasswordInPasswordField(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To click login button",
  "keyword": "And "
});
formatter.match({
  "location": "Myt_challenges.toClickLoginButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To close the browser",
  "keyword": "Then "
});
formatter.match({
  "location": "Myt_challenges.toCloseTheBrowser()"
});
formatter.result({
  "status": "passed"
});
});