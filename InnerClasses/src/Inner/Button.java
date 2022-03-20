package Inner;

public class Button {

    private String title;
    private OnCLickListener onCLickLister;

    public Button(String title){ //constructor
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setOnClickListener(OnCLickListener onClickListener){
        this.onCLickLister = onClickListener;
    }

    public void onClick(){
        this.onCLickLister.onCLick(this.title);
    }

    //needs a interface for onClick
    public interface OnCLickListener {
        public void onCLick(String title);
    }

}
