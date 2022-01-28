package com.example.gotravelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_recurso.*
import kotlinx.android.synthetic.main.activity_add_recurso.btnExit
import kotlinx.android.synthetic.main.activity_add_recurso.btnPerfil

class addRecurso : AppCompatActivity(), AdapterView.OnItemClickListener {
    private val db = FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_recurso)
        val bundle: Bundle? =intent.extras
        val isEdit: Boolean? = bundle?.getBoolean("isEdit")
        val email:String? = bundle?.getString("email")
        vista(email?:"")
        editar(email?:"", isEdit?:false)
        botonera(email ?: "")


    }

    private fun vista(email: String) {
        // select anidado provincias
        var provin = resources.getStringArray(R.array.array_provincias)
        val adaptador = ArrayAdapter(this, android.R.layout.simple_spinner_item,provin )
        with(provincia){ setAdapter(adaptador)
            onItemClickListener= this@addRecurso

        }


        // select anidado atractivos
        var atractivos = resources.getStringArray(R.array.array_atractivo)
        val adapt = ArrayAdapter(this, android.R.layout.simple_spinner_item, atractivos )
        with(categoria_atractivo){ setAdapter(adapt)
            onItemClickListener= this@addRecurso

        }
        btnGuardar01.setOnClickListener(){

            val listaDatos = arrayOf(
                txtNombreLugar.text.toString(),
                categoria_atractivo.text.toString(),
                tipo_atractivo.text.toString(),
                subtipo_atractivo.text.toString(),
                provincia.text.toString(),
                canton.text.toString(),
                parroquia.text.toString(),
                txtCalleP.text.toString(),
                txtNumero.text.toString(),
                txtTrans.text.toString(),
                txtBarrio.text.toString(),
                txtLong.text.toString(),
                txtAltura.text.toString(),
                txtTipoAdmin.text.toString(),
                txtNombreAdmin.text.toString(),
                txtTelefono.text.toString()
            )

            val inicio: Intent = Intent(this,addRecurso01::class.java).apply {
                putExtra("email", email)
                putExtra("respuestas",listaDatos)
            }
            startActivity(inicio)

        }

    }

    private fun editar(email: String, isEdit: Boolean){
        if(isEdit){
            db.collection("atractivos").document(email).get().addOnSuccessListener {
                txtNombreLugar.setText(it.get("NombredelLugar") as String?)
                categoria_atractivo.setText(it.get("Categoria Atractivo") as String?)
                tipo_atractivo.setText(it.get("Tipo Atractivo") as String?)
                subtipo_atractivo.setText(it.get("Subtipo Atractivo") as String?)
                provincia.setText(it.get("Provincia") as String?)
                canton.setText(it.get("Canton") as String?)
                parroquia.setText(it.get("Parroquia") as String?)
                txtCalleP.setText(it.get("Calle") as String?)
                txtNumero.setText(it.get("Numero") as String?)
                txtTrans.setText(it.get("Transversal") as String?)
                txtBarrio.setText(it.get("Barrio") as String?)
                txtLong.setText(it.get("Longitud") as String?)
                txtAltura.setText(it.get("Altura") as String?)
                txtTipoAdmin.setText(it.get("Tipo de Adminstrador") as String?)
                txtNombreAdmin.setText(it.get("Nombre Administrador") as String?)
                txtTelefono.setText(it.get("Telefono") as String?)
            }
        }
    }


    private fun botonera(email:String){
        btnHome01.setOnClickListener(){
            val inicio: Intent= Intent(this,Menu::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }

        btnPerfil.setOnClickListener(){
            val inicio: Intent= Intent(this,Perfil::class.java).apply {
                putExtra("email", email)
            }
            startActivity(inicio)
        }

        btnExit.setOnClickListener{
            val saltar: Intent =Intent(this,MainActivity::class.java)
            startActivity(saltar)
        }
    }


    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {

        val item = parent?.getItemAtPosition(position).toString()

        if (item == "ATRACTIVO NATURAL") {
            var natural = resources.getStringArray(R.array.array_atractivo_natural)
            val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, natural)
            with(tipo_atractivo) {
                setAdapter(adapter)
                onItemClickListener = this@addRecurso

            }
        } else {
            if (item == "MONTAÑAS") {
                var cant = resources.getStringArray(R.array.array_atractivo_montania)
                val adapter =
                    ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                with(subtipo_atractivo) {
                    setAdapter(adapter)
                    onItemClickListener = this@addRecurso
                }

            } else {
                if (item == "DESIERTOS") {
                    var cant = resources.getStringArray(R.array.array_atractivo_desiertos)
                    val adapter =
                        ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                    with(subtipo_atractivo) {
                        setAdapter(adapter)
                        onItemClickListener = this@addRecurso

                    }
                } else {
                    if (item == "AMBIENTES LACUSTRES") {
                        var cant =
                            resources.getStringArray(R.array.array_atractivo_ambientes_lacustres)
                        val adapter =
                            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                        with(subtipo_atractivo) {
                            setAdapter(adapter)
                            onItemClickListener = this@addRecurso
                        }
                    } else{
                        if (item == "RÍOS") {
                            var cant =
                                resources.getStringArray(R.array.array_atractivo_rios)
                            val adapter =
                                ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                            with(subtipo_atractivo) {
                                setAdapter(adapter)
                                onItemClickListener = this@addRecurso
                            }
                        } else{
                            if (item == "BOSQUES") {
                                var cant =
                                    resources.getStringArray(R.array.array_atractivo_bosques)
                                val adapter =
                                    ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                with(subtipo_atractivo) {
                                    setAdapter(adapter)
                                    onItemClickListener = this@addRecurso
                                }
                            } else {
                                if (item == "AGUAS SUBTERRÁNEAS") {
                                    var cant =
                                        resources.getStringArray(R.array.array_atractivo_subterraneas)
                                    val adapter =
                                        ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                    with(subtipo_atractivo) {
                                        setAdapter(adapter)
                                        onItemClickListener = this@addRecurso
                                    }
                                } else {
                                    if (item == "FENÓMENOS ESPELEOLÓGICOS") {
                                        var cant =
                                            resources.getStringArray(R.array.array_atractivo_espeleleologicos)
                                        val adapter =
                                            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                        with(subtipo_atractivo) {
                                            setAdapter(adapter)
                                            onItemClickListener = this@addRecurso
                                        }
                                    } else {
                                        if (item == "FENÓMENOS GEOLÓGICOS") {
                                            var cant =
                                                resources.getStringArray(R.array.array_atractivo_geologicos)
                                            val adapter =
                                                ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                            with(subtipo_atractivo) {
                                                setAdapter(adapter)
                                                onItemClickListener = this@addRecurso
                                            }
                                        } else {
                                            if (item == "COSTAS O LITORALES") {
                                                var cant =
                                                    resources.getStringArray(R.array.array_atractivo_litoraales)
                                                val adapter =
                                                    ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                                with(subtipo_atractivo) {
                                                    setAdapter(adapter)
                                                    onItemClickListener = this@addRecurso
                                                }
                                            } else {
                                                if (item == "AMBIENTES MARINOS") {
                                                    var cant =
                                                        resources.getStringArray(R.array.array_atractivo_marinos)
                                                    val adapter =
                                                        ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                                    with(subtipo_atractivo) {
                                                        setAdapter(adapter)
                                                        onItemClickListener = this@addRecurso
                                                    }
                                                } else {
                                                    if (item == "TIERRAS INSULARES") {
                                                        var cant =
                                                            resources.getStringArray(R.array.array_atractivo_insulares)
                                                        val adapter =
                                                            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                                        with(subtipo_atractivo) {
                                                            setAdapter(adapter)
                                                            onItemClickListener = this@addRecurso
                                                        }
                                                    } else {
                                                        if (item == "MANISFESTACIONES CULTURALES") {
                                                            var cultural =
                                                                resources.getStringArray(R.array.array_atractivo_cultural)
                                                            val adapter =
                                                                ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cultural)
                                                            with(tipo_atractivo) {
                                                                setAdapter(adapter)
                                                                onItemClickListener = this@addRecurso
                                                            }
                                                        } else {
                                                            if (item == "ARQUITECTURA") {
                                                                var cant =
                                                                    resources.getStringArray(R.array.array_cultural_arquitectura)
                                                                val adapter =
                                                                    ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                                                with(subtipo_atractivo) {
                                                                    setAdapter(adapter)
                                                                    onItemClickListener = this@addRecurso
                                                                }
                                                            } else {
                                                                if (item == "ACERVO CULTURAL Y POPULAR") {
                                                                    var cant =
                                                                        resources.getStringArray(R.array.array_cultural_acervo_popular)
                                                                    val adapter =
                                                                        ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                                                    with(subtipo_atractivo) {
                                                                        setAdapter(adapter)
                                                                        onItemClickListener = this@addRecurso
                                                                    }
                                                                } else {
                                                                    if (item == "REALIZACIONES TÉCNICAS Y CIENTÍFICAS") {
                                                                        var cant =
                                                                            resources.getStringArray(R.array.array_cultural_tecnicas_cientificas)
                                                                        val adapter =
                                                                            ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                                                        with(subtipo_atractivo) {
                                                                            setAdapter(adapter)
                                                                            onItemClickListener = this@addRecurso
                                                                        }
                                                                    } else {
                                                                        if (item == "ACONTECIMIENTOS PROGRAMADOS") {
                                                                            var cant =
                                                                                resources.getStringArray(R.array.array_cultural_aconte_programados)
                                                                            val adapter =
                                                                                ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
                                                                            with(subtipo_atractivo) {
                                                                                setAdapter(adapter)
                                                                                onItemClickListener = this@addRecurso
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }



        if (item == "AZUAY") {
            var cant = resources.getStringArray(R.array.array_azuay_cantones)
            val adapter =
                ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cant)
            with(canton) {
                setAdapter(adapter)
                onItemClickListener = this@addRecurso

            }
        } else {
            if (item == "CUENCA") {
                var parr = resources.getStringArray(R.array.array_azuay_cant_cuenca)
                val adapter =
                    ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, parr)
                with(parroquia) {
                    setAdapter(adapter)
                    onItemClickListener = this@addRecurso

                }

            } else {
                if (item == "GIRÓN") {
                    var parr = resources.getStringArray(R.array.array_azuay_cant_girón)
                    val adapter =
                        ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, parr)
                    with(parroquia) {
                        setAdapter(adapter)
                        onItemClickListener = this@addRecurso

                    }
                } else {
                    if (item == "GUALACEO") {
                        var parr = resources.getStringArray(R.array.array_azuay_cant_gualaceo)
                        val adapter =
                            ArrayAdapter(
                                this,
                                R.layout.support_simple_spinner_dropdown_item,
                                parr
                            )
                        with(parroquia) {
                            setAdapter(adapter)
                            onItemClickListener = this@addRecurso

                        }
                    } else {
                        if (item == "NABÓN") {
                            var parr = resources.getStringArray(R.array.array_azuay_cant_nabón)
                            val adapter =
                                ArrayAdapter(
                                    this,
                                    R.layout.support_simple_spinner_dropdown_item,
                                    parr
                                )
                            with(parroquia) {
                                setAdapter(adapter)
                                onItemClickListener = this@addRecurso
                                //parro = "COCHAPATA"
                            }
                        } else {
                            if (item == "PAUTE") {
                                var parr =
                                    resources.getStringArray(R.array.array_azuay_cant_paute)
                                val adapter =
                                    ArrayAdapter(
                                        this,
                                        R.layout.support_simple_spinner_dropdown_item,
                                        parr
                                    )
                                with(parroquia) {
                                    setAdapter(adapter)
                                    onItemClickListener = this@addRecurso
                                }
                            } else {
                                if (item == "PUCARA") {
                                    var parr =
                                        resources.getStringArray(R.array.array_azuay_cant_pucara)
                                    val adapter =
                                        ArrayAdapter(
                                            this,
                                            R.layout.support_simple_spinner_dropdown_item,
                                            parr
                                        )
                                    with(parroquia) {
                                        setAdapter(adapter)
                                        onItemClickListener = this@addRecurso
                                    }
                                } else {
                                    if (item == "SAN FERNANDO") {
                                        var parr =
                                            resources.getStringArray(R.array.array_azuay_cant_san_fernando)
                                        val adapter =
                                            ArrayAdapter(
                                                this,
                                                R.layout.support_simple_spinner_dropdown_item,
                                                parr
                                            )
                                        with(parroquia) {
                                            setAdapter(adapter)
                                            onItemClickListener = this@addRecurso
                                        }
                                    } else {
                                        if (item == "SANTA ISABEL") {
                                            var parr =
                                                resources.getStringArray(R.array.array_azuay_cant_santa_isabel)
                                            val adapter =
                                                ArrayAdapter(
                                                    this,
                                                    R.layout.support_simple_spinner_dropdown_item,
                                                    parr
                                                )
                                            with(parroquia) {
                                                setAdapter(adapter)
                                                onItemClickListener = this@addRecurso
                                            }
                                        } else {
                                            if (item == "SIGSIG") {
                                                var parr =
                                                    resources.getStringArray(R.array.array_azuay_cant_sigsig)
                                                val adapter =
                                                    ArrayAdapter(
                                                        this,
                                                        R.layout.support_simple_spinner_dropdown_item,
                                                        parr
                                                    )
                                                with(parroquia) {
                                                    setAdapter(adapter)
                                                    onItemClickListener = this@addRecurso
                                                }
                                            } else {
                                                if (item == "OÑA") {
                                                    var parr =
                                                        resources.getStringArray(R.array.array_azuay_cant_onia)
                                                    val adapter =
                                                        ArrayAdapter(
                                                            this,
                                                            R.layout.support_simple_spinner_dropdown_item,
                                                            parr
                                                        )
                                                    with(parroquia) {
                                                        setAdapter(adapter)
                                                        onItemClickListener = this@addRecurso
                                                    }
                                                } else {
                                                    if (item == "CHORDELEG") {
                                                        var parr =
                                                            resources.getStringArray(R.array.array_azuay_cant_chordeleg)
                                                        val adapter =
                                                            ArrayAdapter(
                                                                this,
                                                                R.layout.support_simple_spinner_dropdown_item,
                                                                parr
                                                            )
                                                        with(parroquia) {
                                                            setAdapter(adapter)
                                                            onItemClickListener =
                                                                this@addRecurso
                                                        }
                                                    } else {
                                                        if (item == "EL PAN") {
                                                            var parr =
                                                                resources.getStringArray(R.array.array_azuay_cant_el_pan)
                                                            val adapter =
                                                                ArrayAdapter(
                                                                    this,
                                                                    R.layout.support_simple_spinner_dropdown_item,
                                                                    parr
                                                                )
                                                            with(parroquia) {
                                                                setAdapter(adapter)
                                                                onItemClickListener =
                                                                    this@addRecurso
                                                            }
                                                        } else {
                                                            if (item == "SEVILLA DE ORO") {
                                                                var parr =
                                                                    resources.getStringArray(R.array.array_azuay_cant_sevilla_oro)
                                                                val adapter =
                                                                    ArrayAdapter(
                                                                        this,
                                                                        R.layout.support_simple_spinner_dropdown_item,
                                                                        parr
                                                                    )
                                                                with(parroquia) {
                                                                    setAdapter(adapter)
                                                                    onItemClickListener =
                                                                        this@addRecurso
                                                                }
                                                            } else {
                                                                if (item == "GUACHAPALA") {
                                                                    var parr =
                                                                        resources.getStringArray(
                                                                            R.array.array_azuay_cant_guachapala
                                                                        )
                                                                    val adapter =
                                                                        ArrayAdapter(
                                                                            this,
                                                                            R.layout.support_simple_spinner_dropdown_item,
                                                                            parr
                                                                        )
                                                                    with(parroquia) {
                                                                        setAdapter(adapter)
                                                                        onItemClickListener =
                                                                            this@addRecurso
                                                                    }
                                                                } else {
                                                                    if (item == "CAMILO PONCE ENRIQUEZ") {
                                                                        var parr =
                                                                            resources.getStringArray(
                                                                                R.array.array_azuay_cant_camilo_enriquez
                                                                            )
                                                                        val adapter =
                                                                            ArrayAdapter(
                                                                                this,
                                                                                R.layout.support_simple_spinner_dropdown_item,
                                                                                parr
                                                                            )
                                                                        with(parroquia) {
                                                                            setAdapter(adapter)
                                                                            onItemClickListener =
                                                                                this@addRecurso
                                                                        }
                                                                    } else {
                                                                        if (item == "BOLÍVAR") {
                                                                            var cant =
                                                                                resources.getStringArray(
                                                                                    R.array.array_bolivar_cantones
                                                                                )
                                                                            val adapter =
                                                                                ArrayAdapter(
                                                                                    this,
                                                                                    R.layout.support_simple_spinner_dropdown_item,
                                                                                    cant
                                                                                )
                                                                            with(canton) {
                                                                                setAdapter(
                                                                                    adapter
                                                                                )
                                                                                onItemClickListener =
                                                                                    this@addRecurso
                                                                            }
                                                                        } else {
                                                                            if (item == "GUARANDA") {
                                                                                var parr =
                                                                                    resources.getStringArray(
                                                                                        R.array.array_bolivar_guaranda
                                                                                    )
                                                                                val adapter =
                                                                                    ArrayAdapter(
                                                                                        this,
                                                                                        R.layout.support_simple_spinner_dropdown_item,
                                                                                        parr
                                                                                    )
                                                                                with(parroquia) {
                                                                                    setAdapter(
                                                                                        adapter
                                                                                    )
                                                                                    onItemClickListener =
                                                                                        this@addRecurso
                                                                                }
                                                                            } else {
                                                                                if (item == "CHILLANES") {
                                                                                    var parr =
                                                                                        resources.getStringArray(
                                                                                            R.array.array_bolivar_chillanes
                                                                                        )
                                                                                    val adapter =
                                                                                        ArrayAdapter(
                                                                                            this,
                                                                                            R.layout.support_simple_spinner_dropdown_item,
                                                                                            parr
                                                                                        )
                                                                                    with(
                                                                                        parroquia
                                                                                    ) {
                                                                                        setAdapter(
                                                                                            adapter
                                                                                        )
                                                                                        onItemClickListener =
                                                                                            this@addRecurso
                                                                                    }
                                                                                } else {
                                                                                    if (item == "CHIMBO") {
                                                                                        var parr =
                                                                                            resources.getStringArray(
                                                                                                R.array.array_bolivar_chimbo
                                                                                            )
                                                                                        val adapter =
                                                                                            ArrayAdapter(
                                                                                                this,
                                                                                                R.layout.support_simple_spinner_dropdown_item,
                                                                                                parr
                                                                                            )
                                                                                        with(
                                                                                            parroquia
                                                                                        ) {
                                                                                            setAdapter(
                                                                                                adapter
                                                                                            )
                                                                                            onItemClickListener =
                                                                                                this@addRecurso
                                                                                        }
                                                                                    } else {
                                                                                        if (item == "ECHEANDÍA") {
                                                                                            var parr =
                                                                                                resources.getStringArray(
                                                                                                    R.array.array_bolivar_echeandia
                                                                                                )
                                                                                            val adapter =
                                                                                                ArrayAdapter(
                                                                                                    this,
                                                                                                    R.layout.support_simple_spinner_dropdown_item,
                                                                                                    parr
                                                                                                )
                                                                                            with(
                                                                                                parroquia
                                                                                            ) {
                                                                                                setAdapter(
                                                                                                    adapter
                                                                                                )
                                                                                                onItemClickListener =
                                                                                                    this@addRecurso
                                                                                            }
                                                                                        } else {
                                                                                            if (item == "SAN MIGUEL") {
                                                                                                var parr =
                                                                                                    resources.getStringArray(
                                                                                                        R.array.array_bolivar_san_miguel
                                                                                                    )
                                                                                                val adapter =
                                                                                                    ArrayAdapter(
                                                                                                        this,
                                                                                                        R.layout.support_simple_spinner_dropdown_item,
                                                                                                        parr
                                                                                                    )
                                                                                                with(
                                                                                                    parroquia
                                                                                                ) {
                                                                                                    setAdapter(
                                                                                                        adapter
                                                                                                    )
                                                                                                    onItemClickListener =
                                                                                                        this@addRecurso
                                                                                                }
                                                                                            } else {
                                                                                                if (item == "CALUMA") {
                                                                                                    var parr =
                                                                                                        resources.getStringArray(
                                                                                                            R.array.array_bolivar_caluma
                                                                                                        )
                                                                                                    val adapter =
                                                                                                        ArrayAdapter(
                                                                                                            this,
                                                                                                            R.layout.support_simple_spinner_dropdown_item,
                                                                                                            parr
                                                                                                        )
                                                                                                    with(
                                                                                                        parroquia
                                                                                                    ) {
                                                                                                        setAdapter(
                                                                                                            adapter
                                                                                                        )
                                                                                                        onItemClickListener =
                                                                                                            this@addRecurso
                                                                                                    }
                                                                                                } else {
                                                                                                    if (item == "LAS NAVES") {
                                                                                                        var parr =
                                                                                                            resources.getStringArray(
                                                                                                                R.array.array_bolivar_las_naves
                                                                                                            )
                                                                                                        val adapter =
                                                                                                            ArrayAdapter(
                                                                                                                this,
                                                                                                                R.layout.support_simple_spinner_dropdown_item,
                                                                                                                parr
                                                                                                            )
                                                                                                        with(
                                                                                                            parroquia
                                                                                                        ) {
                                                                                                            setAdapter(
                                                                                                                adapter
                                                                                                            )
                                                                                                            onItemClickListener =
                                                                                                                this@addRecurso
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (item == "CAÑAR") {
                                                                                                            var cant =
                                                                                                                resources.getStringArray(
                                                                                                                    R.array.array_caniar_cantones
                                                                                                                )
                                                                                                            val adapter =
                                                                                                                ArrayAdapter(
                                                                                                                    this,
                                                                                                                    R.layout.support_simple_spinner_dropdown_item,
                                                                                                                    cant
                                                                                                                )
                                                                                                            with(
                                                                                                                canton
                                                                                                            ) {
                                                                                                                setAdapter(
                                                                                                                    adapter
                                                                                                                )
                                                                                                                onItemClickListener =
                                                                                                                    this@addRecurso
                                                                                                            }
                                                                                                        } else {
                                                                                                            if (item == "AZOGUES") {
                                                                                                                var parr =
                                                                                                                    resources.getStringArray(
                                                                                                                        R.array.array_caniar_azogues
                                                                                                                    )
                                                                                                                val adapter =
                                                                                                                    ArrayAdapter(
                                                                                                                        this,
                                                                                                                        R.layout.support_simple_spinner_dropdown_item,
                                                                                                                        parr
                                                                                                                    )
                                                                                                                with(
                                                                                                                    parroquia
                                                                                                                ) {
                                                                                                                    setAdapter(
                                                                                                                        adapter
                                                                                                                    )
                                                                                                                    onItemClickListener =
                                                                                                                        this@addRecurso
                                                                                                                }
                                                                                                            } else {
                                                                                                                if (item == "BIBLIÁN") {
                                                                                                                    var parr =
                                                                                                                        resources.getStringArray(
                                                                                                                            R.array.array_caniar_biblian
                                                                                                                        )
                                                                                                                    val adapter =
                                                                                                                        ArrayAdapter(
                                                                                                                            this,
                                                                                                                            R.layout.support_simple_spinner_dropdown_item,
                                                                                                                            parr
                                                                                                                        )
                                                                                                                    with(
                                                                                                                        parroquia
                                                                                                                    ) {
                                                                                                                        setAdapter(
                                                                                                                            adapter
                                                                                                                        )
                                                                                                                        onItemClickListener =
                                                                                                                            this@addRecurso
                                                                                                                    }
                                                                                                                } else {
                                                                                                                    if (item == "CAÑAR.") {
                                                                                                                        var parr =
                                                                                                                            resources.getStringArray(
                                                                                                                                R.array.array_caniar_caniar
                                                                                                                            )
                                                                                                                        val adapter =
                                                                                                                            ArrayAdapter(
                                                                                                                                this,
                                                                                                                                R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                parr
                                                                                                                            )
                                                                                                                        with(
                                                                                                                            parroquia
                                                                                                                        ) {
                                                                                                                            setAdapter(
                                                                                                                                adapter
                                                                                                                            )
                                                                                                                            onItemClickListener =
                                                                                                                                this@addRecurso
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                        if (item == "LA TRONCAL") {
                                                                                                                            var parr =
                                                                                                                                resources.getStringArray(
                                                                                                                                    R.array.array_caniar_la_troncal
                                                                                                                                )
                                                                                                                            val adapter =
                                                                                                                                ArrayAdapter(
                                                                                                                                    this,
                                                                                                                                    R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                    parr
                                                                                                                                )
                                                                                                                            with(
                                                                                                                                parroquia
                                                                                                                            ) {
                                                                                                                                setAdapter(
                                                                                                                                    adapter
                                                                                                                                )
                                                                                                                                onItemClickListener =
                                                                                                                                    this@addRecurso
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                            if (item == "EL TAMBO") {
                                                                                                                                var parr =
                                                                                                                                    resources.getStringArray(
                                                                                                                                        R.array.array_caniar_el_tambo
                                                                                                                                    )
                                                                                                                                val adapter =
                                                                                                                                    ArrayAdapter(
                                                                                                                                        this,
                                                                                                                                        R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                        parr
                                                                                                                                    )
                                                                                                                                with(
                                                                                                                                    parroquia
                                                                                                                                ) {
                                                                                                                                    setAdapter(
                                                                                                                                        adapter
                                                                                                                                    )
                                                                                                                                    onItemClickListener =
                                                                                                                                        this@addRecurso
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                                if (item == "DÉLEG") {
                                                                                                                                    var parr =
                                                                                                                                        resources.getStringArray(
                                                                                                                                            R.array.array_caniar_deleg
                                                                                                                                        )
                                                                                                                                    val adapter =
                                                                                                                                        ArrayAdapter(
                                                                                                                                            this,
                                                                                                                                            R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                            parr
                                                                                                                                        )
                                                                                                                                    with(
                                                                                                                                        parroquia
                                                                                                                                    ) {
                                                                                                                                        setAdapter(
                                                                                                                                            adapter
                                                                                                                                        )
                                                                                                                                        onItemClickListener =
                                                                                                                                            this@addRecurso
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                    if (item == "SUSCAL") {
                                                                                                                                        var parr =
                                                                                                                                            resources.getStringArray(
                                                                                                                                                R.array.array_caniar_suscal
                                                                                                                                            )
                                                                                                                                        val adapter =
                                                                                                                                            ArrayAdapter(
                                                                                                                                                this,
                                                                                                                                                R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                                parr
                                                                                                                                            )
                                                                                                                                        with(
                                                                                                                                            parroquia
                                                                                                                                        ) {
                                                                                                                                            setAdapter(
                                                                                                                                                adapter
                                                                                                                                            )
                                                                                                                                            onItemClickListener =
                                                                                                                                                this@addRecurso
                                                                                                                                        }
                                                                                                                                    } else {
                                                                                                                                        if (item == "CARCHI") {
                                                                                                                                            var cant =
                                                                                                                                                resources.getStringArray(
                                                                                                                                                    R.array.array_carchi_cantones
                                                                                                                                                )
                                                                                                                                            val adapter =
                                                                                                                                                ArrayAdapter(
                                                                                                                                                    this,
                                                                                                                                                    R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                                    cant
                                                                                                                                                )
                                                                                                                                            with(
                                                                                                                                                canton
                                                                                                                                            ) {
                                                                                                                                                setAdapter(
                                                                                                                                                    adapter
                                                                                                                                                )
                                                                                                                                                onItemClickListener =
                                                                                                                                                    this@addRecurso
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                            if (item == "TULCÁN") {
                                                                                                                                                var parr =
                                                                                                                                                    resources.getStringArray(
                                                                                                                                                        R.array.array_carchi_tulcan
                                                                                                                                                    )
                                                                                                                                                val adapter =
                                                                                                                                                    ArrayAdapter(
                                                                                                                                                        this,
                                                                                                                                                        R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                                        parr
                                                                                                                                                    )
                                                                                                                                                with(
                                                                                                                                                    parroquia
                                                                                                                                                ) {
                                                                                                                                                    setAdapter(
                                                                                                                                                        adapter
                                                                                                                                                    )
                                                                                                                                                    onItemClickListener =
                                                                                                                                                        this@addRecurso
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                                if (item == "LOJA") {
                                                                                                                                                    var cant =
                                                                                                                                                        resources.getStringArray(
                                                                                                                                                            R.array.array_loja_cantones
                                                                                                                                                        )
                                                                                                                                                    val adapter =
                                                                                                                                                        ArrayAdapter(
                                                                                                                                                            this,
                                                                                                                                                            R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                                            cant
                                                                                                                                                        )
                                                                                                                                                    with(
                                                                                                                                                        canton
                                                                                                                                                    ) {
                                                                                                                                                        setAdapter(
                                                                                                                                                            adapter
                                                                                                                                                        )
                                                                                                                                                        onItemClickListener =
                                                                                                                                                            this@addRecurso
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                    if (item == "CATAMAYO") {
                                                                                                                                                        var parr =
                                                                                                                                                            resources.getStringArray(
                                                                                                                                                                R.array.array_loja_catamayo
                                                                                                                                                            )
                                                                                                                                                        val adapter =
                                                                                                                                                            ArrayAdapter(
                                                                                                                                                                this,
                                                                                                                                                                R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                                                parr
                                                                                                                                                            )
                                                                                                                                                        with(
                                                                                                                                                            parroquia
                                                                                                                                                        ) {
                                                                                                                                                            setAdapter(
                                                                                                                                                                adapter
                                                                                                                                                            )
                                                                                                                                                            onItemClickListener =
                                                                                                                                                                this@addRecurso

                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        if (item == "CELICA") {
                                                                                                                                                            var parr =
                                                                                                                                                                resources.getStringArray(
                                                                                                                                                                    R.array.array_loja_celica
                                                                                                                                                                )
                                                                                                                                                            val adapter =
                                                                                                                                                                ArrayAdapter(
                                                                                                                                                                    this,
                                                                                                                                                                    R.layout.support_simple_spinner_dropdown_item,
                                                                                                                                                                    parr
                                                                                                                                                                )
                                                                                                                                                            with(
                                                                                                                                                                parroquia
                                                                                                                                                            ) {
                                                                                                                                                                setAdapter(
                                                                                                                                                                    adapter
                                                                                                                                                                )
                                                                                                                                                                onItemClickListener =
                                                                                                                                                                    this@addRecurso

                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }

                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }

            }
        }

    }

}