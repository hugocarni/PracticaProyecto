package Empresa;

import java.util.Objects;

public class Empleado {
//este comentario lo ha echo hugocarni
	// Atributos

		private final String nombre;
		private final String dni;
		private double sueldoBruto;
		private int edad;
		private String telefono;
		private String direccion;

		// Constructores

		public Empleado(String nombre, String dni, double sueldoBruto) {
			this.nombre = nombre;
			this.dni = dni;
			this.sueldoBruto = sueldoBruto;
			this.edad = 0;
			this.telefono = "";
			this.direccion = "";
		}

		public Empleado(String nombre, String dni, double sueldoBruto, int edad, String telefono, String direccion) {
			this.nombre = nombre;
			this.dni = dni;
			this.sueldoBruto = sueldoBruto;
			this.edad = edad;
			this.telefono = telefono;
			this.direccion = direccion;
		}

		// Getters y setters

		public String getNombre() {
			return this.nombre;
		}

		public String getDNI() {
			return this.dni;
		}

		public double getSueldoBruto() {
			return this.sueldoBruto;
		}

		public void setSueldoBruto(double sueldoBruto) {
			this.sueldoBruto = sueldoBruto;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public String getTelefono() {
			return this.telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getDireccion() {
			return this.direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		// Métodos

		// Método para calcular el sueldo neto del empleado

		public double calculaSueldoNeto() {
			double irpf = 0;

			double sueldoBrutoAnual = calcularSueldoBrutoAnual();

			irpf = calcularIRPFSegunSueldo(sueldoBrutoAnual);

			double descuentoIrpf = (sueldoBruto * irpf) / 100;
			
			return this.sueldoBruto - descuentoIrpf;
		}

		private double calcularSueldoBrutoAnual() {
			return this.getSueldoBruto() * 12;
		}

		//Recordad que este método podría llevarse a una clase que tuviera el método como estático (SueldoUtils,java por ejemplo)
		private double calcularIRPFSegunSueldo(double sueldoBrutoAnual) {
			double irpf;
			if (sueldoBrutoAnual < 12000) {
				irpf = 20.0;
			} else if (sueldoBrutoAnual >= 12000 && sueldoBrutoAnual <= 25000) {
				irpf = 30.0;
			} else {
				irpf = 40.0;
			}
			return irpf;
		}

		// Método para imprimir la información del empleado

		public void imprimeEmpleado() {
			System.out.println("Empleado --> Nombre: " + this.getNombre() + "  DNI: " + this.getDNI() + "  Sueldo Bruto: "
					+ this.getSueldoBruto() + "  Edad: " + this.getEdad() + "  Teléfono: " + this.getTelefono()
					+ "  Dirección: " + this.getDireccion());
		}

		@Override
		public int hashCode() {
			return Objects.hash(dni);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Empleado other = (Empleado) obj;
			return Objects.equals(dni, other.dni);
		}

		public boolean remove(Empleado empleado) {
			// TODO Auto-generated method stub
			return false;
		}
}
