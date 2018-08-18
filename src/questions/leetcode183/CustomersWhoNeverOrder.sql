Select Name as Customers
from Customers
where Id not in
(Select customerId from Orders)