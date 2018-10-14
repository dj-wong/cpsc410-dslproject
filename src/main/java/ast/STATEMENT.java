package ast;

import libs.Node;

public  abstract class STATEMENT extends Node {
    public static STATEMENT getSubStatement(){
        if (tokenizer.checkToken("create location")) {
            return new LOCATIONDEC();
        }
        if (tokenizer.checkToken("create locations")) {
            return new LOCATIONSDEC();
        }
        if (tokenizer.checkToken("create marker")) {
            return new MARKERDEC();
        }
        if (tokenizer.checkToken("create markers")) {
            return new MARKERSDEC();
        }
        if (tokenizer.checkToken("create shape")) {
            return new SHAPEDEC();
        }
        if (tokenizer.checkToken("create line")) {
            return new LINEDEC();
        }
        if (tokenizer.checkToken("add infowindow")) {
            return new INFOWINDOWDEC();
        }

        else return null;
    }
}
