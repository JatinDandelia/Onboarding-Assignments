require 'rubygems'
require 'selenium-webdriver'
require_relative '../pages/search_page.rb'

Given ('I am on Amazon website') do
  @amazon_search_page = SearchPage.new($driver)
  @amazon_search_page.visit_amazon_site
end

When ('I search for Mobile Phone') do
  @amazon_search_page.search_box ('mobile phone')
  @amazon_search_page.search_button
end

Then ('Title should contain mobile phone') do
  @tested = @amazon_search_page.title
  @amazon_search_page.close
  expect(@tested).to eq(true)
end
