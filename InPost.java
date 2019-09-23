/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectocalculadora;
import pilas.*;

/**
 *
 * @author daniel
 */
public class InPost extends PilaA{
    private String operacion;
    
    public InPost(String op){
        super();
        operacion=op;
    }
    
    public boolean esNumero(char caracter){
        boolean res=false;
        try{
            Character.getNumericValue(caracter);
            res=true;
        }catch(Exception e){
            System.err.print(e);
        }
        return res;
    }
    
    public int esOperador(char c){
        int res;
        switch(c){
            case '+':
                res=3;
                break;
            case '-':
                res=3;
                break;
            case '*':
                res=2;
                break;
            case '/':
                res=2;
                break;
            case '^':
                res=1;
                break;
            default:
                res=-1;
                break;
        }
        return res;
    }
 
    
    public String cambio(){
        StringBuilder sb;
        char c;
        sb=new StringBuilder();
        PilaA <Character> pila= new PilaA <>();
        for(int i=0;i<operacion.length();i++){
            c=operacion.charAt(i);
            if(esNumero(c)){
                sb.append(c);
            }
            if(c=='('){
                pila.push(c);
            }
            if(c==')'){
                while(pila.peek()!='(')
                    sb.append(pila.pop());
                pila.pop();
            }
            if(esOperador(c)!=-1){
                while(!pila.isEmpty() && esOperador(c)<=esOperador(operacion.charAt(i))){
                    sb.append(pila.pop());
                }
                pila.push(c);
                
            }  
        }
        return sb.toString();
    }
    
    
    
    
}
