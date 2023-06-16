/*
Title	: Vital Signs Interpreter
Author: @Rukawaaaaa
*/

#include <stdio.h>

int main(){

	int upperbp, lowerbp, pulse, respiration;
	int opt, opt1, opt2, score = 0, restart;
	float temp;
	char name [50];

	do{
		
	printf("-----------------------------------------------\n");
	printf("          Vital Signs Interpreter             \n");
	printf("----------------------------------------------\n");

	printf("I'm Rukawaaaaa, your vital signs interpreter.\n");
	printf("> What should I call you: ");
		scanf("%s" ,&name);

	printf("----------------------------------------------\n");

	printf("My system is not sensitive of your age and sex.\n" ,name);
	printf("> Do you still wish to continue? 1) Yes 2) No:\n");
	printf("----------------------------------------------\n");
	printf("> %s, enter the number of your choice: " ,name);
		scanf("%d" ,&opt1);

	//Outer switch
	switch(opt1){

		case 1: 
			printf("----------------------------------------------\n");
			printf("\t\tOptions: \n");
			printf("\t1. Temperature\n");
			printf("\t2. Pulse rate\n");
			printf("\t3. Respiration rate\n");
			printf("\t4. Blood pressure\n");
			printf("\t5. Check all vital signs\n");
			printf("\t6. See Legend\n");
			printf("----------------------------------------------\n");
			printf("> %s, enter the number of your choice: " ,name);
				scanf("%d" ,&opt);
			printf("----------------------------------------------\n");
		
			//Nested switch
			switch (opt) 
			{
				//Temperature
				case 1:
					printf("> Enter your temperature in degree celsius: ");
						scanf("%f" ,&temp);

					printf("----------------------------------------------\n");

					printf("Vital Sign Readings:\n");
						if (temp < 36.1){
							score++;
							printf("* %s, your temperature is low.\n" ,name);
							printf("* You may be experiencing hypothermia.\n");
						}
						else if (temp >= 36.1 && temp <= 37.2){
							printf("* %s, your temperature is normal.\n" ,name);
						}
						else if (temp > 37.2 && temp < 40){
							score++;
							printf("* %s, your temperature is high.\n" ,name);
							printf("* You have a febrile temperature.\n");
						} 
						else if (temp >= 40){
							score++;
							printf("* %s, your temperature is extremely high.\n" ,name);
							printf("* You're experiencing hyperthermia.\n");
						}
						else printf("* An error has occured. Invalid input! Try again.\n");

						printf("----------------------------------------------\n");

						printf("# Abnormalities found: %d\n" ,score);

						printf("----------------------------------------------\n");

						printf("\t\tOptions: \n");
						printf("\t1. Restart Program\n");
						printf("\t2. End Program\n");

						printf("----------------------------------------------\n");

						printf("> %s, enter the number of your choice: " ,name);
						scanf("%d" ,&opt2);

						printf("----------------------------------------------\n");

					//Nested switch
					switch(opt2)
					{
						case 1: 
							printf("\t\tRestarting Program...\n" ,name);
							break;

						case 2: 
							printf("Thank you for using Rukawaaaaa, %s!" ,name);
							break; 

						default: 
							printf("An error has occured. Invalid input! Try again.\n");
					}
					break; 

			//Pulse rate 
			case 2: 
				printf("> Enter your pulse rate per minute: ");
					scanf("%d" ,&pulse);

				printf("----------------------------------------------\n");

				printf("Vital Sign Readings:\n");
					if (pulse <= 35){
						score++;
						printf("* %s, your pulse rate is critically low.\n" ,name);
						printf("* You're experiencing bradycardia.\n");
					}
					else if (pulse > 35 && pulse < 50){
						printf("* %s, your pulse rate is lower than normal.\n" ,name);
						printf("* However, it is typical for athletic people.\n");
					}
					else if (pulse >= 50 && pulse <=90){
						printf("* %s, your pulse rate is normal.\n" ,name);
					}
					else if (pulse > 90 && pulse <= 100){
						score++;
						printf("* %s, your pulse rate is reaching risk territory.\n" ,name);
						printf("* You may be experiencing tachycardia.\n");
					}
					else if (pulse > 100){
						score++;
						printf("* %s, your pulse rate is extremely high.\n" ,name);
						printf("* You're experiencing tachycardia.\n");
					}
					else printf("* An error has occured. Invalid input! Try again.\n");

					printf("----------------------------------------------\n");

					printf("# Abnormalities found: %d\n" ,score);

					printf("----------------------------------------------\n");

					printf("\t\tOptions: \n");
					printf("\t1. Restart Program\n");
					printf("\t2. End Program\n");

					printf("----------------------------------------------\n");

					printf("> %s, enter the number of your choice: " ,name);
					scanf("%d" ,&opt2);

					printf("----------------------------------------------\n");

					switch(opt2){

						case 1: 
							printf("\t\tRestarting Program...\n" ,name);
							break;

						case 2: 
							printf("Thank you for using Rukawaaaaa, %s!" ,name);
							break; 

						default: 
							printf("An error has occured. Invalid input! Try again.\n");
					}
					break; 

			//Respiration rate
			case 3: 
				printf("> Enter your respiration rate per minute: ");
					scanf("%d" ,&respiration);

				printf("----------------------------------------------\n");

				printf("Vital Sign Readings:\n");
					if (respiration < 10){
						score++;
						printf("* %s, your breathing rate is below normal.\n" ,name);
						printf("* You're experiencing hypoventilation.\n");
					}
					else if (respiration >= 10 && respiration <=20){
						printf("* %s, your breathing rate is normal.\n" ,name);
					}
					else if (respiration > 20){
						score++;
						printf("* %s, your breathing rate is above normal.\n" ,name);
						printf("* You're hyperventilating.\n");
					}
					else printf("* An error has occured. Invalid input! Try again.\n");

					printf("----------------------------------------------\n");

					printf("# Abnormalities found: %d\n" ,score);

					printf("----------------------------------------------\n");

					printf("\t\tOptions: \n");
					printf("\t1. Restart Program\n");
					printf("\t2. End Program\n");

					printf("----------------------------------------------\n");

					printf("> %s, enter the number of your choice: " ,name);
					scanf("%d" ,&opt2);

					printf("----------------------------------------------\n");

					//Nested switch 2
					switch(opt2){

						case 1: 
							printf("\t\tRestarting Program...\n" ,name);
							break;

						case 2: 
							printf("Thank you for using Rukawaaaaa, %s!" ,name);
							break; 

						default: 
							printf("An error has occured. Invalid input! Try again.\n");
					}
					break; //End of nested switch 2

			//Blood pressure
			case 4: 
				printf("> Enter your systolic blood pressure: ");
					scanf("%d", &upperbp);
				printf("> Enter your diastolic blood pressure: ");
					scanf("%d", &lowerbp);

				printf("----------------------------------------------\n");

				printf("Vital Sign Readings:\n");
					if (upperbp <= 90 && lowerbp <= 60){
						score++;
						printf("* %s, your blood pressure is low.\n" ,name);
						printf("* You are experiencing hypotension.\n");
					}
					else if (upperbp < 120 && lowerbp < 80)
					{
						printf("* %s, your blood pressure is normal.\n" ,name);
					}
					else if (upperbp <= 129 && lowerbp < 80)
					{
						score++;
						printf("* %s, your blood pressure is elevated.\n" ,name);
					}
					else if (upperbp <= 139 && lowerbp <= 89)
					{
						score++;
						printf("* %s, your blood pressure is high.\n" ,name);
						printf("* Level: High Blood Pressure (Stage 1)\n");
					}
					else if (upperbp >= 140 && lowerbp >= 90)
					{
						score++;
						printf("* %s, your blood pressure is alarmingly high.\n" ,name);
						printf("* Level: High Blood Pressure (Stage 2)\n");
					}
					else if (upperbp > 180 && lowerbp <= 150)
					{
						score++;
						printf("* %s, your blood pressure is extremely high.\n" ,name);
						printf("* You are experiencing a hypertensive crisis.\n");
					}
					else printf("* An error has occured. Invalid input! Try again.\n");

					printf("----------------------------------------------\n");

					printf("# Abnormalities found: %d\n" ,score);

					printf("----------------------------------------------\n");

					printf("\t\tOptions: \n");
					printf("\t1. Restart Program\n");
					printf("\t2. End Program\n");

					printf("----------------------------------------------\n");

					printf("> %s, enter the number of your choice: " ,name);
					scanf("%d" ,&opt2);

					printf("----------------------------------------------\n");

					switch(opt2){

						case 1: 
							printf("\t\tRestarting Program...\n" ,name);
							break;

						case 2: 
							printf("Thank you for using Rukawaaaaa, %s!" ,name);
							break; 

						default: 
							printf("An error has occured. Invalid input! Try again.\n");
					}
					break;  

			//Check all vital signs at once
			case 5: 
				printf("Checking all vital signs...\n");
				printf("> Enter your temperature in degree celsius: ");
					scanf("%f" ,&temp);
				printf("> Enter your pulse rate per minute: ");
					scanf("%d" ,&pulse);
				printf("> Enter your respiration rate per minute: ");
					scanf("%d" ,&respiration);
				printf("> Enter your systolic blood pressure: ");
					scanf("%d", &upperbp);
				printf("> Enter your diastolic blood pressure: ");
					scanf("%d", &lowerbp);

				printf("----------------------------------------------\n");

				printf("%s, here are your vital sign readings...\n" ,name);

				//Temperature 
				printf("> Temperature:\n");
					if (temp < 36.1){
						score++;
						printf("* Your temperature is low.\n");
						printf("* You are experiencing hypothermia.\n");
					}
					else if (temp > 36.1 && temp < 37.2){
						printf("* Your temperature is normal.\n");
					}
					else if (temp > 37.2){
						score++;
						printf("* Your temperature is high.\n");
						printf("* You are experiencing hyperthermia.\n");
					}
					else printf("* An error has occured. Invalid input! Try again.\n");

				//Pulse rate
				printf("> Pulse Rate:\n");
					if (pulse <= 35){
						score++;
						printf("* Your pulse rate is critically low.\n");
						printf("* You're experiencing bradycardia.\n");
					}
					else if (pulse > 35 && pulse < 50){
						printf("* Your pulse rate is lower than normal.\n");
						printf("* However, it is typical for athletic people.\n");
					}
					else if (pulse >= 50 && pulse <=90){
						printf("* Your pulse rate is normal.\n");
					}
					else if (pulse > 90 && pulse <=100){
						score++;
						printf("* Your pulse rate is reaching risk territory.\n");
						printf("* You may be experiencing tachycardia.\n");
					}
					else if (pulse > 100){
						score++;
						printf("* Your pulse rate is extremely high.\n");
						printf("* You're experiencing tachycardia.\n");
					}
					else printf("* An error has occured. Invalid input! Try again.\n");

				//Respiration rate
				printf("> Respiration Rate:\n");
					if (respiration < 10){
						score++;
						printf("* Your breathing rate is below normal.\n");
						printf("* You're experiencing hypoventilation.\n");
					}
					else if (respiration >= 10 && respiration <=20){
						printf("* Your breathing rate is normal.\n");
					}
					else if (respiration > 20){
						score++;
						printf("* Your breathing rate is above normal.\n");
						printf("* You're hyperventilating.\n");
					}
					else printf("* An error has occured. Invalid input! Try again.\n");

				//Blood Pressure
				printf("> Blood Pressure:\n");
					if (upperbp <= 90 && lowerbp <= 60){
						score++;
						printf("* Your blood pressure is low.\n");
						printf("* You are experiencing hypotension.\n");
					}
					else if (upperbp < 120 && lowerbp < 80)
					{
						printf("* Your blood pressure is normal.\n");
					}
					else if (upperbp <= 129 && lowerbp < 80)
					{
						score++;
						printf("* Your blood pressure is elevated.\n");
					}
					else if (upperbp <= 139 && lowerbp <= 89)
					{
						score++;
						printf("* Your blood pressure is high.\n");
						printf("* Level: High Blood Pressure (Stage 1)\n");
					}
					else if (upperbp >= 140 && lowerbp >= 90)
					{
						score++;
						printf("* Your blood pressure is alarmingly high.\n");
						printf("* Level: High Blood Pressure (Stage 2)\n");
					}
					else if (upperbp > 180 && lowerbp <= 150)
					{
						score++;
						printf("* Your blood pressure is extremely high.\n");
						printf("* You are experiencing a hypertensive crisis.\n");
					}
					else printf("* An error has occured. Invalid input! Try again.\n");

					printf("----------------------------------------------\n");

					printf("# Abnormalities found: %d\n" ,score);

					printf("----------------------------------------------\n");

					printf("\t\tOptions: \n");
					printf("\t1. Restart Program\n");
					printf("\t2. End Program\n");

					printf("----------------------------------------------\n");

					printf("> %s, enter the number of your choice: " ,name);
					scanf("%d" ,&opt2);

					printf("----------------------------------------------\n");

					switch(opt2){

						case 1: 
							printf("\t\tRestarting Program...\n" ,name);
							break;

						case 2: 
							printf("Thank you for using Rukawaaaaa, %s!" ,name);
							break; 

						default: 
							printf("An error has occured. Invalid input! Try again.\n");
					}
					break; 

			//Legend
			case 6: 
				printf("\t\tLegend:\n");
				printf("Temperature\t 	Readings\n");
				printf("<36.1 \t 		Hypothermia\n");
				printf("36.1-37.2 \t 	Normal Temperature\n");
				printf("37.2-40  		Febrile Temperature\n");
				printf(">40  			Hyperthermia\n");

				printf("----------------------------------------------\n");

				printf("Pulse Rate\t\tReadings\n");
				printf("<35 \t 		Bradycardia\n");
				printf("35-49 \t 		Normal for Athletes\n");
				printf("50-90 \t 		Normal Pulse Rate\n");
				printf("91-100 \t\t 	Risk Territory\n");
				printf(">100 \t 		Tachycardia\n");

				printf("----------------------------------------------\n");

				printf("Respiration Rate \tReadings\n");
				printf("<10 \t 		Hypoventilation\n");
				printf("10-20 \t 		Normal Breathing Rate\n");
				printf(">20 \t 		Hyperventilation\n");

				printf("----------------------------------------------\n");

				printf("Blood Pressure\t\tReadings\n");
				printf("0-90 / 0-60  		Hypotension\n");
				printf("<120 / <80 \t 	Normal Blood Pressure\n");
				printf("120-129 / <80\t 	Elevated Blood Pressure\n");
				printf("130-139 / 80-89\t\tHigh Blood Pressure (Stage 1)\n");
				printf(">140 / >90\t  	High Blood Pressure (Stage 2)\n");
				printf(">180 / >120\t  	Hypertensive Crisis\n");

				printf("----------------------------------------------\n");

				printf("\t\tOptions: \n");
				printf("\t1. Restart Program\n");
				printf("\t2. End Program\n");

				printf("----------------------------------------------\n");

				printf("> %s, enter the number of your choice: " ,name);
				scanf("%d" ,&opt2);

				printf("----------------------------------------------\n");

				switch(opt2){

					case 1: 
						printf("\t   Restarting Program...\n" ,name);
						break;

					case 2: 
						printf("Thank you for using Rukawaaaaa, %s!" ,name);
						break; 

					default: 
						printf("An error has occured. Invalid input! Try again.\n");
				}
				break; 

			default: printf("An error has occured. Invalid input! Try again.\n");
		}
		break; //End of switch case 1 for outer switch

	case 2:
		printf("---------------------------- ------------------\n");
		printf("Okay, thank you for considering using Rukawaaaaa.\n");
		break;

	default: 
		printf("An error has occured. Invalid input! Try again.");
	} 
	//End of switch case 2 for outer switch

	}while(opt2 == 1);

	return 0;

}