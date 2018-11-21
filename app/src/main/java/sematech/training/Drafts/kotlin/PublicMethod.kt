package sematech.training.Drafts.kotlin

import android.content.Context
import android.widget.Toast

class PublicMethod {

    companion object {
        fun toast(mContext: Context,msg:String ){
            Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show()

        }

    }
}