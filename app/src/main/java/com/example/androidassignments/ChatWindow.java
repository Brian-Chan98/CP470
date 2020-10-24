package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    protected final static String ACTIVITY_NAME = "ChatWindowActivity";
    private ListView chatList;
    private EditText chatText;
    private Button sendButton;
    ArrayList<String> messages = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        chatList = (ListView) findViewById(R.id.ChatList);
        chatText = (EditText) findViewById(R.id.ChatText);
        sendButton = (Button) findViewById((R.id.SendButton));

        final ChatAdapter messageAdapter = new ChatAdapter(this);
        chatList.setAdapter(messageAdapter);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messages.add(chatText.getText().toString());
                messageAdapter.notifyDataSetChanged();
                chatText.setText("");
            }
        });
    }

    private class ChatAdapter extends ArrayAdapter<String>{
        public ChatAdapter(Context ctx){
            super(ctx, 0);
        }

        //returns number of rows in the chat list (number of strings in the ArrayList --> messages
        public int getCount(){
            return messages.size();
        }

        //returns item to show in the list at specified position
        public String getItem(int position){
            return messages.get(position);
        }

        //returns layout that will be positioned at specific row
        public View getView(int position, View convertView, ViewGroup parent){
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result = null;

            if(position%2 == 0){
                result = inflater.inflate(R.layout.chat_row_incoming, null);
            } else {
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            }

            TextView message = (TextView) result.findViewById(R.id.message_text);
            message.setText(getItem(position));

            return result;
        }
    }
}