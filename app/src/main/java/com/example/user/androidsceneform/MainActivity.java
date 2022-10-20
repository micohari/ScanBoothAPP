package com.example.user.androidsceneform;

import android.graphics.Camera;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.Sun;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;
    private ModelRenderable containerRenderable,
                            galvalumRenderable,
                            kayuRenderable,
                            alumuniumRenderable;

    private Button btnRemove;
    private AnchorNode anchorNode;
    ImageView container,galvalum,kayu,alumunium;

    View arrayView[];
    ViewRenderable name_booth;

    int selected = 1;
    ViewRenderable booth_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment)getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);
        btnRemove = (Button)findViewById(R.id.remove);
        //view
        container = (ImageView)findViewById(R.id.container);
        galvalum = (ImageView)findViewById(R.id.galvalum);
        kayu = (ImageView)findViewById(R.id.kayu);
        alumunium = (ImageView)findViewById(R.id.alumunium);



        setArrayView();
        setClickListener();

        setupModel();
        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                //when user tap on plane, we well model

                    Anchor anchor = hitResult.createAnchor();
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    anchorNode.setParent(arFragment.getArSceneView().getScene());

                    createModel (anchorNode,selected);

            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteObject (anchorNode);

            }
        });

    }

    private void deleteObject(AnchorNode anchorNode) {

        List<Node> children = new ArrayList<>(arFragment.getArSceneView().getScene().getChildren());
        for (Node node:children){
            if (node instanceof  AnchorNode){
                if (((AnchorNode)node).getAnchor() != null){
                    ((AnchorNode)node).getAnchor().detach();
                }
            }

        }
    }


    private void setupModel() {

        ViewRenderable.builder()
                .setView(this,R.layout.name_booth)
                .build()
                .thenAccept(renderable -> name_booth = renderable);

        ModelRenderable.builder()
                .setSource(this, R.raw.container)
                .build().thenAccept(renderable -> containerRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "unnable to load container model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.galvalum)
                .build().thenAccept(renderable -> galvalumRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "unnable to load galvalum model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.kayu)
                .build().thenAccept(renderable -> kayuRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "unnable to load kayu model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable.builder()
                .setSource(this, R.raw.alumunium)
                .build().thenAccept(renderable -> alumuniumRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "unnable to load alumunium model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );


    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1)
        {
            TransformableNode container = new TransformableNode(arFragment.getTransformationSystem());
            container.setParent(anchorNode);
            container.setRenderable(containerRenderable);
            container.select();

            addName (anchorNode,container,"Container");

        }
        if (selected == 2)
        {
            TransformableNode galvalum = new TransformableNode(arFragment.getTransformationSystem());
            galvalum.setParent(anchorNode);
            galvalum.setRenderable(galvalumRenderable);
            galvalum.select();

            addName (anchorNode,galvalum,"Galvalum");
        }

        if (selected == 3)
        {
            TransformableNode kayu = new TransformableNode(arFragment.getTransformationSystem());
            kayu.setParent(anchorNode);
            kayu.setRenderable(kayuRenderable);
            kayu.select();

            addName (anchorNode,kayu,"Kayu");
        }
        if (selected == 4)
        {
            TransformableNode alumunium = new TransformableNode(arFragment.getTransformationSystem());
            alumunium.setParent(anchorNode);
            alumunium.setRenderable(alumuniumRenderable);
            alumunium.select();

            addName (anchorNode,alumunium,"Alumunium");
        }

    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {
        TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
        nameView.setLocalPosition(new Vector3(0f,model.getLocalPosition().y+0.5f,0));
        nameView.setParent(anchorNode);
        nameView.setRenderable(name_booth);
        nameView.select();

        //set Text

        TextView txt_name = (TextView)name_booth.getView();
        txt_name.setText(name);
        //Click to text view to remove animal
        txt_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anchorNode.setParent(null);
            }
        });

    }

    private void setClickListener() {

        for (int i=0;i<arrayView.length;i++)
            arrayView[i].setOnClickListener(this);

    }

    private void setArrayView() {
        arrayView = new View[]{
                container,galvalum,kayu,alumunium
        };
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.container) {
            selected = 1;
            setBackground(v.getId());
        }
        else if (v.getId() == R.id.galvalum) {
            selected = 2;
            setBackground(v.getId());
        }
        else if (v.getId() == R.id.kayu) {
            selected = 3;
            setBackground(v.getId());
        }
        else if (v.getId() == R.id.alumunium) {
            selected = 4;
            setBackground(v.getId());
        }
    }

    private void setBackground(int id) {
        for (int i=0;i<arrayView.length;i++)
        {
            if (arrayView[i].getId() == id)
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
        }
    }





}
