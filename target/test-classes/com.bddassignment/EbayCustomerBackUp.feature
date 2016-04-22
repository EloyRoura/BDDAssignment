Feature: ebay search
    As a new ebay customer
    I want to be able to shop for an item I want, to look for the cheapest
    item available and use the filtering options available.

    Background: A web browser
        Given I open the website

    Scenario: item search
        When I search for iPhone
        And I list the "Buy it now"
        And I sort by "Highest Price"
        Then I see the first item at £16000

    Scenario: item search
        When I search for iPhone
        And I list the "Auction"
        And I sort by "Highest Price"
        Then I see the first item at £3000
        And it has 0 bids

    Scenario: item search
        When I search for iPhone
        And I list the "Buy it now"
        And I sort by "Newly listed"
        Then I see the first item at £800.0
        And it has "NonFree" Postage

    Scenario: item search
        When I search for iPhone
        And I list the "Buy it now"
        And I sort by "Lowest Price + P&P"
        Then I see the first item at £0.99

    Scenario: item search
        When I search for iPhone
        And I list the "All listings"
        And I sort by "Best Match"
        Then I see the first item at £249.99
        And there are 12117 items