package com.example.fixacaopolimorfismo;

import com.example.fixacaopolimorfismo.entities.ImportedProduct;
import com.example.fixacaopolimorfismo.entities.Product;
import com.example.fixacaopolimorfismo.entities.UsedProduct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/*Fazer um programa para ler os dados de N produtos (N fornecido pelo usuário). Ao final, mostrar a etiqueta de preço de
* cada produto na mesma ordem em que foram digitados. Todos produtos possui nome e preço. Produtos importados possuem
* uma taxa de aldândega, e produtos usados possuem data de fabricação. Estes dados específicos devem ser acrescentados
* na etiqueta de preço conforme exemplo. Para produtos importados, a taxa e açfandega deve ser acrescentada ao preço
* final do produto.
* */

@SpringBootApplication
public class FixacaoPolimorfismoApplication {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Product> product = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            System.out.println("Product #" + i + " data?");
            System.out.print("Common, used or imported (c/u/i)?");
            char resp = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if(resp == 'i'){
                System.out.print("Customs fee: ");
                double customsfee = sc.nextDouble();
                Product imported = new ImportedProduct(name, price, customsfee);
                product.add(imported);
            }else if(resp == 'c'){
                Product comum = new Product(name, price);
                product.add(comum);
            }else{
                System.out.println("Manunfacture date (DD/MM/YYYY)");
                Date data = sdf.parse(sc.next());
                Product used = new UsedProduct(name, price, data);
                product.add(used);
            }

            System.out.println();
            System.out.println("PRICE TAGS");
            for(Product prod : product){
                System.out.println(prod.priceTag());
            }
        }

    }

}
