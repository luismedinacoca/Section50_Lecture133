Feature: Products
  Scenario Outline: validate promo code alert is visible when clickin ob the special offers link
    Given user navigates to "<url>" website
    When user clicks on "<button>"
    Then user should be presented with a promo alert
    Examples:
      | url                                                            | button                  |
      | http://webdriveruniversity.com/Page-Object-Model/products.html | //*[@id='amp-img']      |
      | http://webdriveruniversity.com/Page-Object-Model/products.html | //*[@id='camera-img']   |
      | http://webdriveruniversity.com/Page-Object-Model/products.html | //*[@id='laptop1']      |
      | http://webdriveruniversity.com/Page-Object-Model/products.html | //*[@id='laptop2']      |
      | http://webdriveruniversity.com/Page-Object-Model/products.html | //*[@id='nintendo']     |
      | http://webdriveruniversity.com/Page-Object-Model/products.html | //*[@id='graphic-card'] |
      | http://webdriveruniversity.com/Page-Object-Model/products.html | //*[@id='computer']     |
      | http://webdriveruniversity.com/Page-Object-Model/products.html | //*[@id='boombox']      |