# Farm Collector
## API operations to view reports for a farm based crop planted and harvested
You can visit the postman collection attached to this repo to view the collections of API request
Description:
Organization “FarmCollector” wants to collect information from Farmers for every field for
every season, per farm (2 API):
1. Planted:
a. Planting Area (in acres).
b. Type of crops planted.
c. Amount of Expected product (in tons)
2. Harvested:
a. Actual amount of harvested product.
Organization “FarmCollector” want to see reports for every season shows expected vs actual
amount of product:
1. For each farm
2. For each Type of crops

For example Farmer from the farm “MyFarm” planted corn and potatoes. He will submit four
sets of data – one for corn, one for potato, where planted then one for corn , one for potatoes,
where harvested.
Reports should be available on the web page for every season.

Verify the deployment by navigating to your server address in
your preferred browser.for api docs

```sh
http://localhost:8080/swagger-ui/index.html
```
# Please add Planted and Harvested Crop before hitting Reports.
You can view reports by 
```sh
http://localhost:8080/index.html
```
# Future Enhancements
1) Dedicated UI for CRUD operations
2) Test coverage - SONAR Integeration
3) Improvements in ERROR handling
4) If possible we can merge Planted and Harvested entities into a single one and get faster reports


## License

MIT
