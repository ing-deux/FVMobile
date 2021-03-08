package uci.fvm;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uci.fvm.fragment.FragmentAuthor;
import uci.fvm.fragment.FragmentBook;
import uci.fvm.fragment.FragmentEditorial;
import uci.fvm.fragment.FragmentHome;
import uci.fvm.fragment.FragmentResource;
import uci.fvm.model.Author;
import uci.fvm.model.Book;
import uci.fvm.model.Controller;
import uci.fvm.model.Editorial;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ViewPager viewPager;
    private static Controller controller;
    private FloatingActionButton fab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = null;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_1);
        setSupportActionBar(toolbar);

        downloadBooks();

        fab = (FloatingActionButton) findViewById(R.id.fab_refresh);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                //Preguntar si tiene conexion a internet
                boolean flag = true;

                while (flag) {
                    animate_fab();
                    downloadBooks();
                    flag = false;
                }

//                Snackbar.make(view, "No se puede conectar en estos momentos", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().
                replace(R.id.content, new FragmentHome()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setQueryHint(getText(R.string.action_search));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, R.string.submitted, Toast.LENGTH_SHORT).show();

                searchView.setQuery("", false);
                searchView.setIconified(true);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;

        if (id == R.id.nav_home) {
            fragment = new FragmentHome();

        } else if (id == R.id.nav_books) {
            fragment = new FragmentBook();

        } else if (id == R.id.nav_authors) {
            fragment = new FragmentAuthor();

        } else if (id == R.id.nav_editorials) {
            fragment = new FragmentEditorial();

        } else if (id == R.id.nav_resources) {
            fragment = new FragmentResource();

        } else if (id == R.id.nav_login) {
            Intent i = new Intent(getBaseContext(), LoginActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_send) {

        }

        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void animate_fab() {
        fab.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_rotate));
    }



    public void downloadBooks() {
        if (controller != null) {
            Log.d("error", "no se pudo crear");
        } else {
            List<Author> authors=new ArrayList<>();
            List<Book> books=new ArrayList<>();
            List<Editorial> editorials=new ArrayList<>();


            int[] editorial_logos=new int[]{
                    R.drawable.e1
            };

            Editorial e= new Editorial("Ediciones Luz", "Cubana", editorial_logos[0]);

            editorials.add(e);

            int[] author_photos = new int[]{
                    R.drawable.a1, R.drawable.a2
            };

            Author a = new Author
                    ("George R. Martin", "Escritor britanico", author_photos[0]);

            authors.add(a);

            a=new Author
                    ("J.K Rowling", "Escritora britanica", author_photos[1]);



            int[] booksCover = new int[]{
                    R.drawable.b1, R.drawable.b2, R.drawable.b3};

            Book b = new Book
                    ("The Lord of the Rings",
                            "Es un libro de aventuras escrito por el autor britanico George no se que mas",
                            "Aventura", booksCover[0]);

            books.add(b);

            b = new Book
                    ("Harry Potter",
                            "Es un libro de ciencia ficcion, futurista, y de mucha accion",
                            "Accion", booksCover[1]);
            books.add(b);

            b = new Book
                    ("Elpidio Valdes",
                            "Es un libro de caricaturas animadas escrito por Juan Padrón, trata sobre...",
                            "Comedia-Animados", booksCover[2]);
            books.add(b);

            controller=new Controller(books,authors,editorials);
        }
    }

    public static List<Author> getAuthors(){
        return controller.getAuthors();
    }

    public static List<Book> getBooks(){
        return controller.getBooks();
    }

    public static List<Editorial> getEditorials(){
        return controller.getEditorials();
    }


    public boolean isConnected(){
        ConnectivityManager cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo=cm.getActiveNetworkInfo();

        if (networkInfo != null || networkInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;
    }
}