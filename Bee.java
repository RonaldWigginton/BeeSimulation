public class Bee {
         // This is the Bee class
         protected int myi;// this is the i location of me in the 
         protected int myj;// this is the j location of me in the 
         protected boolean infected;

      public Bee(int i,int j)
         {// this is the constructor for a Bee object it sets my location and the origional
          infected = false;
          }//End of constructor Bee
          boolean getInfected(){return infected;};
          int getmyi(){return myi;};
          int getmyj(){return myj;};
                
           public boolean randomInfected()
                     {//this is the process generator for the indection of the Bee 
                     //Bees can be infected with a 3% chance per adjacent infected bee
                      int x; // this is the random variante U(0-100)
                      if(this.infected){// In the chance we are found infected we dont want to overwrite our infection.
                          return true; 
                      }
                      x=(int)(Math.random()*100);
                      if(x<3)
                      {
                          return true;
                      }
                        return false;
                        }// end of function randomInfected
            public void updateHealth(Bee [][] hivetable, int myx, int myy)
                    {/* this is the primary behavior of the Bee.  This function will be assessed 
                       for each Bee once per cycle.   It can change health based on the following rules
                        The change can only come if the Bee is adjacent to an infected Bee.
                        Given that the Bee can change it will change if
                              a. 3% per night in all directions
                        */
                        if(!getInfected()){
                        if(myx==0 && myy==0) // check if we are in the top left of the Hive
                        { 
                            if(hivetable[myx][myy+1].getInfected()) // check below 
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx+1][myy].getInfected()) // Check to right
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                        }
                        else if (myx==hivetable.length-1 && myy==0)// We are top Right of the Hive
                        { 
                            if(hivetable[myx][myy+1].getInfected()) // check below 
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx-1][myy].getInfected()) // Check to left
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                        }
                        else if (myx==0 && myy==hivetable[0].length-1) // We Are at the bottom left 
                        {
                            if(hivetable[myx][myy-1].getInfected()) // check above 
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx+1][myy].getInfected()) // Check to Right
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                        }
                        else if (myx==hivetable.length-1 && myy==hivetable[0].length-1) // We are at the bottom Right
                        {
                            if(hivetable[myx][myy-1].getInfected()) // check Above 
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx-1][myy].getInfected()) // Check to left
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                        }
                        else if (myx==0 && myy==hivetable[0].length-1) // we are at the bottom left 
                        {
                            if(hivetable[myx][myy-1].getInfected()) // check Above 
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx+1][myy].getInfected()) // Check to Right
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                        }
                        else if (myx==0) // we are along the left side of the Hive and myy != 0
                        {
                            if (hivetable[myx+1][myy].getInfected()) // Check to Right
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if(hivetable[myx][myy+1].getInfected()) // check Below
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if(hivetable[myx][myy-1].getInfected()) // check Above
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                        } 
                        else if (myx==hivetable.length-1) // we are along the right side of the Hive 
                        {
                            if (hivetable[myx-1][myy].getInfected()) // Check to Left
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                             if(hivetable[myx][myy+1].getInfected()) // check Below
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                             if(hivetable[myx][myy-1].getInfected()) // check Above
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                        }
                        else if(myy==hivetable[0].length-1) // we are along the bottom  
                        {
                            if (hivetable[myx-1][myy].getInfected()) // Check to Left
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                             if(hivetable[myx][myy-1].getInfected()) // check Above
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx+1][myy].getInfected()) // Check to Right
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                        }
                        else if(myy==0) // we are along the top
                        {
                            if(hivetable[myx][myy+1].getInfected()) // check Below
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx+1][myy].getInfected()) // Check to Right
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx-1][myy].getInfected()) // Check to Left
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }

                        }
                        else // we are in the middle of the Hive 
                        {
                            if(hivetable[myx][myy+1].getInfected()) // check Below
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if(hivetable[myx][myy-1].getInfected()) // check Above
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx+1][myy].getInfected()) // Check to Right
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }
                            if (hivetable[myx-1][myy].getInfected()) // Check to Left
                            {
                                this.infected = randomInfected(); // Run Chance of Infection
                            }

                        }
                    } // end of If Not Infected Bee
                    else {
                       // System.out.println("Infected Bee Skipped");
                        }
                        return;             
                    };// end of function updateHealth
}
