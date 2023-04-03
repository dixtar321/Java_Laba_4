//import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class SortedIntegerList{
    private LinkedList<Integer> list;
    private boolean isRepeat;
    private ListIterator<Integer> it;
    private int sort_val;
    
    public SortedIntegerList(boolean isRepeat, int val){
        list = new LinkedList<>();
        this.isRepeat = isRepeat;
        sort_val = val;
    }

    public void reverse(){
        LinkedList<Integer> tmpList = new LinkedList<>();
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            tmpList.add(listIterator.previous());
        }
        list = tmpList;
        if (sort_val == 0)
            sort_val = 1;
        else if(sort_val == 1)
            sort_val = 0;
        }

    // public void reverse(){
    //     ListIterator<Integer> rev = list.listIterator(list.size());
    //     while (rev.previousIndex() > it.nextIndex()) {
    //     Integer t = rev.previous();
    //     rev.set(it.next());
    //     it.set(t);
    //     }
    //     it = rev;
    //     }

    // public void maxTomin(){
    //     ListIterator<Integer> iter = list.listIterator();
    //     Integer current = iter.next();
    //     Integer next = null;
    //     while (iter.hasNext()) {
    //         if (!iter.hasPrevious() && next != null) {
    //             while (iter.hasNext() && iter.next() < next) ;
    //                 iter.previous();
    //                 iter.add(next);
    //          }
    //          next = iter.next();
    //         if (next >= current) {
    //             current = next;
    //         }   else {
    //             iter.remove();
    //             iter = list.listIterator();
    //             current = next;
    //          }
    //     }
    //     reverse();
    // }

    public void add(Integer value) {
        if(sort_val == 0){
            if(list.isEmpty()){
                //it.set(append);
                //it.add(cur_val);
                list.add(value);
            }
            else{
                int countOfIterations = 0;
                boolean isAdded = false;
                if(isRepeat){
                    it = list.listIterator();
                    while(it.hasNext()) {
                        if (value < list.get(countOfIterations)){
                            it.add(value);
                            isAdded = true;
                            break;
                        }
                        else if(value > list.get(countOfIterations)){
                            countOfIterations++;
                            it.next();
                            continue;
                        }
                        countOfIterations++;
                        it.next();
                    }
                    if(!isAdded) {
                        it.add(value);
                    }
                }
                else{
                    list.remove(value);
                    it = list.listIterator();
                    while(it.hasNext() ) {
                        if (value < list.get(countOfIterations)) {
                            it.add(value);
                            isAdded = true;
                            break;
                        }
                        else if(value > list.get(countOfIterations)) {
                            countOfIterations++;
                            it.next();
                            continue;
                        }
                        countOfIterations++;
                        it.next();
                    }
                    if(!isAdded) {
                        it.add(value);
                    }
                }
            }
        }
        else if(sort_val == 1){
            if(list.isEmpty()){
                list.add(value);
            }
            else{
                int countOfIterations = 0;
                boolean isAdded = false;
                if(isRepeat){
                    it = list.listIterator();
                    while(it.hasNext()) {
                        if (value > list.get(countOfIterations)){
                            it.add(value);
                            isAdded = true;
                            break;
                        }
                        else if(value < list.get(countOfIterations)){
                            countOfIterations++;
                            it.next();
                            continue;
                        }
                        countOfIterations++;
                        it.next();
                    }
                    if(!isAdded) {
                        it.add(value);
                    }
                }
                else{
                    list.remove(value);
                    it = list.listIterator();
                    while(it.hasNext() ) {
                        if (value > list.get(countOfIterations)) {
                            it.add(value);
                            isAdded = true;
                            break;
                        }
                        else if(value < list.get(countOfIterations)) {
                            countOfIterations++;
                            it.next();
                            continue;
                        }
                        countOfIterations++;
                        it.next();
                    }
                    if(!isAdded) {
                        it.add(value);
                    }
                }
            }
        }
    }

    public void remove(int value){
        it = list.listIterator();
        while (it.hasNext()){
            if(it.next() == value){
                it.remove();
            }
        }
    }

    public boolean equals(SortedIntegerList otherList){
        if(list.size() != otherList.list.size()){
            return false;
        }
        else{
            it = list.listIterator();
            otherList.it = otherList.list.listIterator();
            while(it.hasNext()){
                if(it.next() != otherList.it.next()){
                    return false;
                }
            }
        }
        return true;
    }

    public void printList(){
        it = list.listIterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.print("\n");
    }
}