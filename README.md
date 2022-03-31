# LibraryMS
Library management system using Hibernate ,Java ,Oracle 

## Classes

User :' Which is Superclass have commen intialization of fields'

Customer : 'Iherite the User Attributes '

Libraraian : 'Iherite the User Attributes '

Publisher :'Iherite the User Attributes '

App : 'Which is the main Contains cofiguration and all function and retrieving '

### Relations Between classes

One to Many : 'Librarian to Customer'
              'Librarian To Books'
              'Librarian To Publisher'
              'Customer To Books'
            
Many to one : 'Books to Customer<To prevent made a seperate table>'
  
Many to Many : 'Publisher to Books' 


#### Related DB Tables 
  
Librarian : -- Librarian,Added_Books , Added_Clients
 
Customer  : -- Customer,Books 

Puplisher : -- Puplisher,Publisher_Books
  
