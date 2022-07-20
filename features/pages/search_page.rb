require 'rubygems'
require 'selenium-webdriver'
require_relative '../support/env.rb'

class SearchPage
  include PageObject

  $text_field = [:search_box, "twotabsearchtextbox"]
  $button = [:search, "nav-search-submit-button"]
 
  def visit_amazon_site
    $driver.get 'http://www.amazon.com'
  end

  def search_box(searchElement)
    search_bar = $wait.until {$driver.find_element(:id => $text_field[1])}
    puts search_bar
    search_bar.send_keys searchElement   
  end

  def search_button()
    button = $wait.until {$driver.find_element(:id => $button[1])}
    button.click
  end
 
  def title()
    @url = $driver.title
    @tested = false
    puts @url
    if (@url.include? "mobile phone")
      $driver.execute_script('browserstack_executor: {"action": "setSessionStatus", "arguments": {"status":"passed", "reason": "Yaay! My test has passed!"}}')
      @tested = true
    else
      $driver.execute_script('browserstack_executor: {"action": "setSessionStatus", "arguments": {"status":"failed", "reason": "Oops! My test has failed!"}}') 
    end
    return @tested
  end
 
  def close
    $driver.close
  end
end