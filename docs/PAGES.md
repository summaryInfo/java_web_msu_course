Every page also contains menu with buttons referring to
Products, Consumers, Providers, Orders, Supplies,
Instances, Product categories and About pages.

## Products
* Search fields
    * id
    * name
    * description
    * type (enumeration built from product_types table)
    * units (enumeration built from unit_types table)
    * oversized (checkbox)
* Apply button that refreshes results list
* Create new button (+), naviagates to "Create or modify product"
* List of all products (query result, split into pages)
    * Every entry is a collapsible, that expands to detailed info, modify and delete buttons and link to "Instances" of this product
* Page switching (forward, backward and page number buttons; for large number of results)

## Create or modify product
* Text fields for every data field in database (name, description, address, phone number, e-mail)
* Submit and undo buttons

## Consumers
* Search fields for id, name, address, phone number, e-mail
* Apply button that refreshes results list
* Create new button (+), naviagates to "Create or modify consumer"
* List of all consumers (query result, split into pages)
    * Every entry is a collapsible, that expands to detailed info, modify and delete buttons
    * Also has link that leads to "Orders" page with consumer set to this consumer
* Page switching (forward, backward and page number buttons; for large number of results)

## Create or modify consumer
* Text fields for every data field in database (name, description, address, phone number, e-mail)
* Submit and cancel buttons

## Providers
* Search fields for id, name, address, phone number, e-mail
* Apply button that refreshes results list
* Create new button (+), naviagates to "Create or modify provider"
* List of all providers (query result, split into pages)
    * Every entry is a collapsible, that expands to detailed info, modify and delete buttons
    * Also has link that leads to "Supplies" page with provider set to this provider
* Page switching (forward, backward and page number buttons; for large number of results)

## Create or modify provider
* Text fields for every data field in database (name, description, address, phone number, e-mail)
* Submit and cancel buttons

## Orders
* Search fields for
    * id
    * consumer (link to "Consumers" with query constrained to this consumer)
    * product (link to "Instances" for this product)
    * count (range)
    * time (range)
    * completed (checkbox)
* Create new button (+), naviagates to "Create or modify order"
* List of all orders (query result, split into pages)
    * Every entry is a collapsible, that expands to detailed info, modify and delete buttons
    * Also has link that leads to "Supplies" page with provider set to this provider
    * Has button to perform order (select appropriate product instances show them and remove from database)
* Page switching (forward, backward and page number buttons; for large number of results)

## Create or modify order
* Text fields for every data field in database (consumer, product, count, time)
* Submit and cancel buttons

## Supplies
* Search fields for
    * id
    * provider (link to "Providers" with query constrained to this consumer)
    * product (link to "Instances" for this product)
    * count (range)
    * time (range)
    * completed (checkbox)
* Create new button (+), naviagates to "Create or modify supply"
* List of all orders (query result, split into pages)
    * Every entry is a collapsible, that expands to detailed info, modify and delete buttons
    * Also has link that leads to "Supplies" page with provider set to this provider
    * Has button to perform supply (create new product instances and show them)
* Page switching (forward, backward and page number buttons; for large number of results)

## Create or modify supply
* Text fields for every data field in database (consumer, product, count, time)
* Submit and cancel buttons

## Instances
* Product info (fields from products page)
* Link to "Products" with query constrained to this product
* List of instances (with location, units, expiration date if any and arrival date)
* Page switching (forward, backward and page number buttons; for large number of results)

## Product categories
* Search fields (id, name, description)
* List of categories (with date fields and link to "Products" with query constrained to this category)
* Create new button (+), naviagates to "Create or modify produt category"
* Page switching (forward, backward and page number buttons; for large number of results)

## Create or modify category
* Data fields
    * Name
    * Description
* Submit and cancel buttons
