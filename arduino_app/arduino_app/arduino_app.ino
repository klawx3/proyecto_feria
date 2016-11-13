const bool DEBUG = true;
//CONST -------------------------------------
const int DIGITAL_OUT_PINS[] = {3,4,5,6};
const int LENGTH_DIGITAL_OUT_PINS = 4;

const int DIGITAL_IN_PINS[] = {7,8,9};
const int LENGTH_DIGITAL_IN_PINS = 3; 

const int ANALOG_PINS[] = {0};
const int LENGTH_ANALOG_PINS = 1;

const long MILLIS_TO_PRINT = 1000;
//VAR ---------------------------------------
long _lastMillis = 0;

void setup() {
  
  for(int i = 0 ; i < LENGTH_DIGITAL_OUT_PINS ; i++){
    pinMode(DIGITAL_OUT_PINS[i],OUTPUT);  
  }
  for(int i = 0 ; i < LENGTH_DIGITAL_IN_PINS ; i++){
    pinMode(DIGITAL_IN_PINS[i],INPUT);  
  }  
  Serial.begin(9600);
}

void loop() {
  readIncomingCharacter_DoSomething();
  printAnalogSensors();
}

void readIncomingCharacter_DoSomething(){
  while(Serial.available() > 0 ){
    String incomingString = Serial.readString();
    turnOnOffDigitalPorts(incomingString);
  }
}

void turnOnOffDigitalPorts(String incomingString){
    boolean on_off = incomingString.startsWith("onn",0); // else "off" incoming
    int pin = incomingString.substring(3).toInt();
    if(pin != 0){ // 0 == read error
       digitalWrite(pin,on_off);
       if(DEBUG){
         Serial.print(pin);    
         Serial.print(" ");
         Serial.println(on_off ? "HIGH" : "LOW");  
       }
    } 
}

void printAnalogSensors(){
    if(millis() - _lastMillis > MILLIS_TO_PRINT ){
        _lastMillis = millis();
        for(int i = 0; i < LENGTH_ANALOG_PINS ; i++){
          print_s(ANALOG_PINS[i],analogRead(ANALOG_PINS[i]),false);
        }      
    }
}

void print_s(int pin,int valor,boolean digital){
  Serial.print(digital ? "d-" : "a-");
  Serial.print(pin);
  Serial.print("-");
  Serial.println(valor);
}
