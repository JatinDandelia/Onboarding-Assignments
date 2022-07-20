require 'selenium-webdriver'
require 'page-object'
Before do
  @caps = Selenium::WebDriver::Remote::Capabilities.new
  @caps['browser'] = 'Chrome'
  @caps['os_version'] = '10'
  @caps['resolution'] = '1920x1080'
  @caps['os'] = 'Windows'
  @caps['browser_version'] = 'latest'
  @caps['javascriptEnabled'] = 'true'
  @caps['name'] = 'BStack-Cucumber Assignment' # test name
  @caps['build'] = 'BStack Build Number 2' # CI/CD job or build name

  $driver = Selenium::WebDriver.for(:remote,
    :url => "https://jatindandelia_qLfxh4:gJCYx1LpA6s1CK4BzSzZ@hub-cloud.browserstack.com/wd/hub",
    :capabilities => @caps)
  $wait = Selenium::WebDriver::Wait.new(:timeout => 20)
end