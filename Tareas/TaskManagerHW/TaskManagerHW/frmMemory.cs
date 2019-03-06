using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TaskManagerHW
{
    public partial class frmMemory : Form
    {
        public frmMemory()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(txtId.Text))
            {
                try
                {
                    var process = Process.GetProcessById(Int32.Parse(txtId.Text));
                    var memoryValue = BytesToReadableValue(process.PrivateMemorySize64);
                    txtMemory.Text = memoryValue;
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Message", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }                       
        }

        public string BytesToReadableValue(long num)
        {
            List<string> sufijos = new List<string> { " B", " KB", " MB" };

            for (int i = 0; i < sufijos.Count; i++)
            {
                long temp = num / (int)Math.Pow(1024, i + 1);

                if (temp == 0)
                {
                    return (num / (int)Math.Pow(1024, i)) + sufijos[i];
                }
            }

            return num.ToString();
        }

        private void frmMemory_Load(object sender, EventArgs e)
        {

        }
    }
}
