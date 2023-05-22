import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String gtNam = "Name", gtNu = "Nu";
        Sex[] sexs = new Sex[10];
        sexs[0] = new Sex(1, "Name1", 18, gtNam);
        sexs[1] = new Sex(1, "Name2", 19, gtNam);
        sexs[2] = new Sex(1, "Name3", 20, gtNam);
        sexs[3] = new Sex(1, "Nu1", 16, gtNu);
        sexs[4] = new Sex(1, "Nu2", 29, gtNu);
        sexs[5] = new Sex(1, "Nu3", 15, gtNu);
        sexs[6] = new Sex(1, "Nu4", 29, gtNu);
        sexs[7] = new Sex(1, "Name4", 20, gtNam);
        sexs[8] = new Sex(1, "Nu5", 30, gtNu);
        sexs[9] = new Sex(1, "Name5", 46, gtNam);
        int minAge=sexs[0].getAge();
        for (int i=0;i< sexs.length;i++){
            for(int j=i+1;j< sexs.length;j++){
                if(sexs[i].getAge()>sexs[j].getAge()){
                    Sex temp= sexs[i];
                    sexs[i]=sexs[j];
                    sexs[j]=temp;
                }
            }
        }
        Queue nam = new LinkedList();
        Queue nu = new LinkedList();
        Queue result= new LinkedList();
        for (int i = 0; i < sexs.length; i++) {
            if (sexs[i].getGt().equals(gtNu)) {
                nu.add(sexs[i]);
            } else if (sexs[i].getGt().equals(gtNam)) {
                nam.add(sexs[i]);
            } else {
                continue;
            }
        }
        if(!nu.isEmpty() && !nam.isEmpty()){
            int count=0;
            while (count!=sexs.length){
                if(!nu.isEmpty() && !nam.isEmpty()){
                    Sex a= (Sex) nu.peek();
                    Sex b=(Sex) nam.peek();
                    if(a.getAge()<= b.getAge()){
                        result.add(a);
                        nu.poll();
                        count+=1;
                    }else {
                        result.add(b);
                        nam.poll();
                        count+=1;

                    }
                }else if(!nu.isEmpty() && nam.isEmpty()){
                    result.add(nu.poll());
                    count+=1;

                }else if(!nam.isEmpty() && nu.isEmpty()){
                    result.add(nam.poll());
                    count+=1;

                }

            }
        }else if (nu.isEmpty()){
            result=nam;
        } else if (nam.isEmpty()) {
            result=nu;
        }
        while (result.size()!=0){
            System.out.println(result.poll().toString());
        }
    }
}