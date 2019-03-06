namespace TaskManagerHW
{
    partial class frmEndTask
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.txtProcessId = new System.Windows.Forms.TextBox();
            this.btnTerminar = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(16, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(218, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Escriba el ID del programa que desa terminar";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(16, 40);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(68, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Identificador:";
            // 
            // txtProcessId
            // 
            this.txtProcessId.Location = new System.Drawing.Point(90, 37);
            this.txtProcessId.Name = "txtProcessId";
            this.txtProcessId.Size = new System.Drawing.Size(144, 20);
            this.txtProcessId.TabIndex = 2;
            // 
            // btnTerminar
            // 
            this.btnTerminar.DialogResult = System.Windows.Forms.DialogResult.OK;
            this.btnTerminar.Font = new System.Drawing.Font("Karla", 9.749999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnTerminar.Location = new System.Drawing.Point(251, 71);
            this.btnTerminar.Name = "btnTerminar";
            this.btnTerminar.Size = new System.Drawing.Size(105, 23);
            this.btnTerminar.TabIndex = 3;
            this.btnTerminar.Text = "Finalizar Tarea";
            this.btnTerminar.UseVisualStyleBackColor = true;
            this.btnTerminar.Click += new System.EventHandler(this.btnTerminar_Click);
            // 
            // frmEndTask
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(368, 106);
            this.Controls.Add(this.btnTerminar);
            this.Controls.Add(this.txtProcessId);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "frmEndTask";
            this.Text = "frmDeleteTask";
            this.Load += new System.EventHandler(this.frmEndTask_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox txtProcessId;
        private System.Windows.Forms.Button btnTerminar;
    }
}