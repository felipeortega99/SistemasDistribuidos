namespace TaskManagerHW
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.opcionesToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ejecutarNuevoProcesoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.terminarProcesoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.consumoDeMemoriaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.tabControl1 = new System.Windows.Forms.TabControl();
            this.tabPage1 = new System.Windows.Forms.TabPage();
            this.listView_Process = new System.Windows.Forms.ListView();
            this.tabPage2 = new System.Windows.Forms.TabPage();
            this.columnHeader1 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader2 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader3 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader4 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.listView_Servicios = new System.Windows.Forms.ListView();
            this.columnHeader5 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader6 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.columnHeader7 = ((System.Windows.Forms.ColumnHeader)(new System.Windows.Forms.ColumnHeader()));
            this.menuStrip1.SuspendLayout();
            this.tabControl1.SuspendLayout();
            this.tabPage1.SuspendLayout();
            this.tabPage2.SuspendLayout();
            this.SuspendLayout();
            // 
            // opcionesToolStripMenuItem
            // 
            this.opcionesToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.ejecutarNuevoProcesoToolStripMenuItem,
            this.terminarProcesoToolStripMenuItem,
            this.consumoDeMemoriaToolStripMenuItem});
            this.opcionesToolStripMenuItem.Font = new System.Drawing.Font("Karla", 9.749999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.opcionesToolStripMenuItem.Name = "opcionesToolStripMenuItem";
            this.opcionesToolStripMenuItem.Size = new System.Drawing.Size(75, 20);
            this.opcionesToolStripMenuItem.Text = "Opciones";
            // 
            // ejecutarNuevoProcesoToolStripMenuItem
            // 
            this.ejecutarNuevoProcesoToolStripMenuItem.Name = "ejecutarNuevoProcesoToolStripMenuItem";
            this.ejecutarNuevoProcesoToolStripMenuItem.Size = new System.Drawing.Size(215, 22);
            this.ejecutarNuevoProcesoToolStripMenuItem.Text = "Ejecutar nuevo proceso";
            this.ejecutarNuevoProcesoToolStripMenuItem.Click += new System.EventHandler(this.ejecutarNuevoProcesoToolStripMenuItem_Click);
            // 
            // terminarProcesoToolStripMenuItem
            // 
            this.terminarProcesoToolStripMenuItem.Name = "terminarProcesoToolStripMenuItem";
            this.terminarProcesoToolStripMenuItem.Size = new System.Drawing.Size(215, 22);
            this.terminarProcesoToolStripMenuItem.Text = "Terminar proceso";
            this.terminarProcesoToolStripMenuItem.Click += new System.EventHandler(this.terminarProcesoToolStripMenuItem_Click);
            // 
            // consumoDeMemoriaToolStripMenuItem
            // 
            this.consumoDeMemoriaToolStripMenuItem.Name = "consumoDeMemoriaToolStripMenuItem";
            this.consumoDeMemoriaToolStripMenuItem.Size = new System.Drawing.Size(215, 22);
            this.consumoDeMemoriaToolStripMenuItem.Text = "Consumo de memoria";
            this.consumoDeMemoriaToolStripMenuItem.Click += new System.EventHandler(this.consumoDeMemoriaToolStripMenuItem_Click);
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.opcionesToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(714, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // tabControl1
            // 
            this.tabControl1.Controls.Add(this.tabPage1);
            this.tabControl1.Controls.Add(this.tabPage2);
            this.tabControl1.Font = new System.Drawing.Font("Karla", 9.749999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.tabControl1.Location = new System.Drawing.Point(13, 28);
            this.tabControl1.Name = "tabControl1";
            this.tabControl1.SelectedIndex = 0;
            this.tabControl1.Size = new System.Drawing.Size(701, 390);
            this.tabControl1.TabIndex = 1;
            // 
            // tabPage1
            // 
            this.tabPage1.Controls.Add(this.listView_Process);
            this.tabPage1.Location = new System.Drawing.Point(4, 24);
            this.tabPage1.Name = "tabPage1";
            this.tabPage1.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage1.Size = new System.Drawing.Size(693, 362);
            this.tabPage1.TabIndex = 0;
            this.tabPage1.Text = "Procesos";
            this.tabPage1.UseVisualStyleBackColor = true;
            this.tabPage1.Click += new System.EventHandler(this.tabPage1_Click);
            // 
            // listView_Process
            // 
            this.listView_Process.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader1,
            this.columnHeader2,
            this.columnHeader3,
            this.columnHeader4,
            this.columnHeader7});
            this.listView_Process.Location = new System.Drawing.Point(6, 6);
            this.listView_Process.Name = "listView_Process";
            this.listView_Process.Size = new System.Drawing.Size(679, 350);
            this.listView_Process.TabIndex = 3;
            this.listView_Process.UseCompatibleStateImageBehavior = false;
            this.listView_Process.View = System.Windows.Forms.View.Details;
            // 
            // tabPage2
            // 
            this.tabPage2.Controls.Add(this.listView_Servicios);
            this.tabPage2.Location = new System.Drawing.Point(4, 24);
            this.tabPage2.Name = "tabPage2";
            this.tabPage2.Padding = new System.Windows.Forms.Padding(3);
            this.tabPage2.Size = new System.Drawing.Size(693, 362);
            this.tabPage2.TabIndex = 1;
            this.tabPage2.Text = "Servicios";
            this.tabPage2.UseVisualStyleBackColor = true;
            // 
            // columnHeader1
            // 
            this.columnHeader1.Text = "Id";
            // 
            // columnHeader2
            // 
            this.columnHeader2.Text = "Nombre";
            this.columnHeader2.Width = 91;
            // 
            // columnHeader3
            // 
            this.columnHeader3.Text = "Machine Name";
            this.columnHeader3.Width = 105;
            // 
            // columnHeader4
            // 
            this.columnHeader4.Text = "Status";
            this.columnHeader4.Width = 98;
            // 
            // listView_Servicios
            // 
            this.listView_Servicios.Columns.AddRange(new System.Windows.Forms.ColumnHeader[] {
            this.columnHeader5,
            this.columnHeader6});
            this.listView_Servicios.Location = new System.Drawing.Point(4, 7);
            this.listView_Servicios.Name = "listView_Servicios";
            this.listView_Servicios.Size = new System.Drawing.Size(683, 349);
            this.listView_Servicios.TabIndex = 0;
            this.listView_Servicios.UseCompatibleStateImageBehavior = false;
            this.listView_Servicios.View = System.Windows.Forms.View.Details;
            // 
            // columnHeader5
            // 
            this.columnHeader5.Text = "Nombre";
            this.columnHeader5.Width = 106;
            // 
            // columnHeader6
            // 
            this.columnHeader6.Text = "Descripción";
            this.columnHeader6.Width = 386;
            // 
            // columnHeader7
            // 
            this.columnHeader7.Text = "Window Title";
            this.columnHeader7.Width = 140;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(714, 420);
            this.Controls.Add(this.tabControl1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.tabControl1.ResumeLayout(false);
            this.tabPage1.ResumeLayout(false);
            this.tabPage2.ResumeLayout(false);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStripMenuItem opcionesToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ejecutarNuevoProcesoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem terminarProcesoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem consumoDeMemoriaToolStripMenuItem;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.TabControl tabControl1;
        private System.Windows.Forms.TabPage tabPage1;
        private System.Windows.Forms.TabPage tabPage2;
        private System.Windows.Forms.ListView listView_Process;
        private System.Windows.Forms.ColumnHeader columnHeader1;
        private System.Windows.Forms.ColumnHeader columnHeader2;
        private System.Windows.Forms.ColumnHeader columnHeader3;
        private System.Windows.Forms.ColumnHeader columnHeader4;
        private System.Windows.Forms.ListView listView_Servicios;
        private System.Windows.Forms.ColumnHeader columnHeader5;
        private System.Windows.Forms.ColumnHeader columnHeader6;
        private System.Windows.Forms.ColumnHeader columnHeader7;
    }
}

