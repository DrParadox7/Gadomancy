package makeo.gadomancy.common.entities.ai;

import net.minecraft.entity.ai.EntityAIBase;

import makeo.gadomancy.common.Gadomancy;
import makeo.gadomancy.common.entities.golems.nbt.ExtendedGolemProperties;
import thaumcraft.common.entities.golems.EntityGolemBase;

/**
 * This class is part of the Gadomancy Mod Gadomancy is Open Source and distributed under the GNU LESSER GENERAL PUBLIC
 * LICENSE for more read the LICENSE file
 * <p/>
 * Created by makeo @ 31.10.2015 20:15
 */
public class AISit extends EntityAIBase {

    private EntityGolemBase golem;
    private ExtendedGolemProperties properties;

    public AISit(EntityGolemBase golem) {
        this.golem = golem;
        this.properties = (ExtendedGolemProperties) golem.getExtendedProperties(Gadomancy.MODID);
        this.setMutexBits(7);
    }

    @Override
    public boolean shouldExecute() {
        return this.properties.isSitting();
    }

    @Override
    public void startExecuting() {
        this.golem.getNavigator().clearPathEntity();
    }

    @Override
    public boolean continueExecuting() {
        this.golem.setTarget(null);

        this.golem.getLookHelper().setLookPosition(0, 0, 0, 0, -45);
        return this.properties.isSitting();
    }
}
