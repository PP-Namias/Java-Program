#include <iostream>
#include <string>
#include <list>

using namespace std;

    string username = "salonspa"; //username
	string password = "54321"; //password
	string inputUsername, inputPassword; //for admin
	int tries = 0; //tries for admin
	const int MAX_TRIES = 100; //admin MAX_TRIES
	
	int action = 0; //Appointment
	const int MAX_ACT = 100; //Appointment

    char servtype, service, receipt, offer, treatment, promo, extra; //products
	float price, pay, total, change;
	
    struct Product { //products
    string name;
    float price;
    float pay;
    float change;
    float total;
    int i;
    };

    const int MAX_PRODUCTS = 100; 
    Product products[MAX_PRODUCTS];
    int productCount = 0;

    struct Appointment
    {
	string customerName;
	string date;
	string time;
    };

    const int MAX_APPOINTMENTS = 30;
    Appointment appointments[MAX_APPOINTMENTS];
    int numAppointments = 0;

void addAppointments();
void displayAppointments();
void searchAppointments();
void appointmentmenu();

int main ()
{
    while (tries < MAX_TRIES) {
		cout<<"Admin Username:";
		cin>>inputUsername;
		cout<<"Admin Password:";
		cin>>inputPassword;
		
		if (inputUsername == username && inputPassword == password) {
			cout<<"SUCCESS!\n"<<endl;
		    appointmentmenu();
		    break;
		}
		
		else {
			cout<<"ERROR! TRY AGAIN...\n"<<endl;
			tries++;
		}
	}
	if (tries == MAX_TRIES) {
		cout<<"\nToo many failed attempts. \nExiting...."<<endl;
	}
        
    	return 0;
}


void addProduct(string name, float price) {
    if (productCount < MAX_PRODUCTS) {
        products[productCount].name = name;
        products[productCount].price = price;
        products[productCount].total = total;
        products[productCount].total = products[productCount].total + products[productCount].price;
        products[productCount].pay = pay;
        products[productCount].change = change;
        productCount++;
    }
    break;
    else {
        cout << "Error: Product list is full." << endl;
        }
}

void printProducts() {
    for (int i = 0; i < productCount; i++) {
        cout <<products[i].name << "\nTotal Price: Php" << products[i].total;
    }
}

void computeProducts() {
    for (int i = 0; i < productCount; i++) {
        
        cout<<"\nCASH: ";
        cin >> products[i].pay;
    
    	 if (products[i].pay > products[i].total) {   
    	    products[i].change = products[i].pay - products[i].total;
    	    cout<<"\nChange:" <<products[i].change<<endl;
    	 }
    	 
    	 else {
    	     cout <<"Insufficient Payment!";
    	     exit(0);
    	 }
      }
}

void addAppointments()
{
    {   
        cout<<"\n*************************"<<endl;
        cout<<"Type of service\n";
    	cout<<"\n\tA.Hair";
    	cout<<"\n\tB.Face";
    	cout<<"\n\tC.Nails/Feet";
    	cout<<"\n\tD.Body";
    	cout<<"\n\tE.Save Service" <<endl;
    	
    	cout<<"\nEnter service: ";
    	cin>>servtype;
	
	switch(servtype) {
	    
		case 'A':
    			cout<<"\n\tHAIR";
    			cout<<"\n\tOffer A: Classic";
    			cout<<"\n\tOffer B: STYLING & SETTING"<<endl;
    			
    			cout<<"\nChoose Offer: """;
    			cin>>offer;
		
			if (offer == 'A') {
			    
                cout<<"\n\tTrim";
    			cout <<"\n\tPrice: Php. 99.00";
                cout<<endl;
                
                cout<<"Promo? Y/N: ";
    		    cin>>promo;
			
			if (promo =='Y') {
    			price = 99 + 70;
    			addProduct("*HAIR*\n\tTrim\n\tSpecial Promo\n\tShampoo\n\tBlowdry\n\tHair Iron\n\tCurl", price );
    			cout<<endl;
			}
			
		    else if (promo =='N') {
			    price = 99 + 0;
			    addProduct("*HAIR*\n\tTrim\n\tWithout Promo", price);
		    	cout<<endl;
			}
			
			else {
			    cout<<"Invalid Option!\n";
		
			}
			}
			
			else if (offer == 'B') {
    		     addProduct("\n\tHAIR\n\tHighlights\n\tBrazilian\n\tRebonding\n\tCellophane", 1000.00 );
			}
    	
			break;
			
			case 'B':
	        	cout<<"\n\tFace";
			    cout<<"\n\tA.Facial Classic";
				cout <<"\n\tPrice: Php. 1599.00"<<endl;
			    cout<<"\n\tB.Facial Treatments:";
				cout <<"\n\tPrice: Php. 1999.00"<<endl;

    			cout<<"\n\tChoose Offer: """;
    			cin>>offer;
    			
    			
    		if (offer == 'A') {
    		        cout<<"\na.Deep cleansing";
        			cout<<"\nb.w vit. c";
        			cout<<"\nc.w vit. c + modelling mask";
        			cout<<"\nd.w collagen";
        			cout<<"\ne.w diamond";
        			cout <<"\nPrice: Php. 1599.00";
         
    		    cout<<"\nExtra Offer? Y/N: ";
    		    cin>>extra;
			
    			if (extra =='Y') {			
    			    addProduct("\n\tThreading or Microblading eyebrows\n\tEyelash extension\n\tSkin tag removal", 1599.00 );
    			}
    			 else if (extra =='N') {
    			     addProduct("\n\tFACE\n\tHighlights\n\tDeep cleansing\n\tw vit. c\n\tw vit. c + modelling mask\n\tw collagen\n\tw.diamond", 1599.00 );
    			     cout<<endl;
    			     break;
    			 }
    			else {
    			    cout<<"Invalid Option!\n";
    			}
    		
    		}
			
    		else if (offer == 'B') {
    			cout<<"\nTreatment a: Acne Treatment";
    			cout<<"\nTreatment b: Melasma Treatment";
				cout<<"\nTreatment c: Face Lifting (non-surgical)";
    				
    			cout<<"\n Choose Treatment:";
    		    cin>>treatment;
    			    
    		    if (treatment == 'a') {
    				addProduct("\nFACE\nTreatment a: Acne Trmnt.\n\tMiamipeel w extraction\n\tFacial w extraction\n\tRadio frequency\n\tw collagen\n\tw.diamond", 1999.00 );
    			}
				
				else if (treatment == 'b') {
					addProduct("\nFACE\nTreatment b: Melasma Trmnt.\n\tMiamipeel\n\tMeso Theraphy", 1599.00 );
        		}
			
    			else if (treatment == 'c') {
    				addProduct("\nFACE\nTreatment a: Face Lifting (non-surgical)\n\tRadio frequency\n\tMeso Theraphy", 1599.00 );
    			}
    				
    				else {
    				    cout<<"Invalid!";
    				}
    			
    			cout<<"Extra Offer? Y/N: ";
    		    cin>>extra;
			
    			if (extra =='Y') {			
    			    addProduct("\nThreading or Microblading eyebrows\nEyelash extension\nSkin tag removal", 1599.00 );
    			}
    			
    			 else if (extra =='N') {
    			}
    			
    			else {
    			    cout<<"Invalid Option!\n";
    			}
    		}
    		break;
    		
    	case 'C':
				cout<<"\nNails/Feet";
		    	cout<<"\nA.Classic Mani & Pedi";
			    cout<<"\nB.Nails Extension";
				cout<<"\nC.FOOTSPA";

			cout<<"\nChoose Offer: """;
			cin>>offer;
			
			if (offer == 'A') {
			    cout<<"\nA.Nail art";
				cout<<"\nB.w gellish";
				cout<<"\nPrice: Php. 99.00";
			    
			    cout<<"\nExtra Offer? Y/N: ";
    		    cin>>extra;
			
    			if (extra =='Y'){
    			    price = 99 + 150;
			        addProduct("\nNails/Feet\nA.Nail art\nB.w gellish\nRemoval Nail gel (not done w us)", price );
				}
				 else if (extra =='N') {
				    addProduct("\nNails/Feet\nA.Nail art\nB.w gellish", 99.00 );
    			}
    			else {
    			    cout<<"Invalid Option!\n";
    			}
			}
				
	   		else if (offer == 'B') {
			    cout<<"\nAcrylic gel";
				cout<<"\nAcrylic gel w french tip";
				cout<<"\nNail Refill";
				cout<<"\nPrice: Php. 150.00";

			    cout<<"\nExtra Offer? Y/N: ";
    		    cin>>extra;
			
    			if (extra =='Y'){
    			    price = 99 + 150;
                    addProduct("\nNails/Feet\nA.Acrylic gel\nB.Acrylic gel w french tip\nC.Nail Refill\nRemoval Nail gel (not done w us)", price );

				}
				 else if (extra =='N') {
				    addProduct("\nNails/Feet\nA.Acrylic gel\nB.Acrylic gel w french tip\nC.Nail Refill", 99.00 );
    			}
    			else {
    			    cout<<"Invalid Option!\n";
    			}
			}
				
				else if (offer == 'C')	{
				    cout<<"\nFootspa";
					cout<<"\nw Paraffin";
					cout<<"\nw wax";
					cout<<"\nPrice: Php. 150.00";
				    addProduct("\nNails/Feet\nA.Footspa\n\tw Paraffin\n\tw wax", 150.00 );
				    
				    if (extra =='Y'){
    			    price = 99 + 150;
                    addProduct("\nNails/Feet\nA.Footspa\n\tw Paraffin\n\tw wax\nRemoval Nail gel (not done w us)", price );

				}
				 else if (extra =='N') {
				    addProduct("\nNails/Feet\nA.Footspa\n\tw Paraffin\n\tw wax", 150.00 );
    			}
    			else {
    			    cout<<"Invalid Option!\n";
    			}
				}
				
                
				break;		
    			
    	    	case 'D':
    		
    		    addProduct("\nBody\nA.Whole body massage\nB.Massage w ventosa\nC.Sauna", 499.00 );
				break;
				
				case 'E':
			    break;
			    
			    default: cout <<"INVALID CHOICE. PLEASE TRY AGAIN!" <<endl;
	}
    }
    
	if(numAppointments == MAX_APPOINTMENTS) {
	cout<<"Sorry"<<endl;
	return;
	}   printProducts();
	    computeProducts();
	    
        cout<<"Enter the customer name: ";
		cin>>appointments[numAppointments].customerName;
		cout<<"Enter the date: ";
		cin>>appointments[numAppointments].date;
		cout<<"Enter the time: ";
		cin>>appointments[numAppointments].time;
	
    
		numAppointments++;
		return;
}
		



void displayAppointments() {
		cout<<"Current Appointments:\n ";
		
		for (int i = 0; i<numAppointments; i++) {
			cout<<"\n"<<appointments[i].customerName<<"\n"<<appointments[i].date<<"\n"<<appointments[i].time<<endl;
			printProducts();
		}
		
}
	
void searchAppointments() {
	string date, time;
	cout<<"Enter the date (mm/dd/yyy): ";
	cin>>date;
	cout<<"Enter the time (hh:mm): ";
	cin>>time;
	
	for (int i = 0; i < numAppointments; i++)
	 {
	 	if (appointments[i].date == date && appointments[i].time == time) {
	 		cout<<"Found Appointment: "<<endl;
	 		cout<<appointments[i].customerName<<"\n"<<appointments[i].date<<"\n"<<appointments[i].time<<endl;
	 		printProducts();
	 		return;
		 }
	 }
	 
	 cout<<"Opps. Sorry! No Appointment..."<<endl;
}


void appointmentmenu() {
	    while (true) {
	    cout<<"\n*************************"<<endl;
		cout<<"\nGlamour Beauty Salon and Spa";
		cout<<"\t\n1. Add Appointment";
		cout<<"\t\n2. List of Appointment";
		cout<<"\t\n3. Search for an Appointment";
		cout<<"\t\n4. EXIT"<<endl;
		
			int choice;
				cout<<"\nEnter your choice: ";
				cin>>choice;
				
				switch(choice)
				{
				case 1: addAppointments();
		    		break;
				
				case 2: displayAppointments();
				    break;
				
				case 3:searchAppointments();
					break;
				
			 	case 4:
				break;
				 
				default: cout <<"INVALID CHOICE. PLEASE TRY AGAIN!" <<endl;
				
				}		
	     }
	}
